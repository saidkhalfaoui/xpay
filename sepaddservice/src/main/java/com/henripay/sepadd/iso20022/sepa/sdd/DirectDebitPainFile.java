package com.henripay.sepadd.iso20022.sepa.sdd;

import static com.google.common.base.Preconditions.checkArgument;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createAccount;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createAmount;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createFinInstnId;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createIdParty;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createParty;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createPaymentIdentification;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createXMLGregorianCalendar;
import static com.henripay.sepadd.iso20022.sepa.sdd.Utils.createXMLGregorianCalendarDate;

import com.henripay.sepadd.api.model.CreditorInfo;
import com.henripay.sepadd.api.model.DirectDebitRequestData;
import com.henripay.sepadd.api.model.Mandateinformation;
import com.henripay.sepadd.dataaccess.model.CreditorInfoJsonObjectMapper;
import com.henripay.sepadd.iso20022.sepa.BasePainFile;
import com.henripay.sepadd.iso20022.sepa.IBANUtils;
import com.henripay.sepadd.service.configuration.ConfigurationService;
import iso.std.iso._20022.tech.xsd.pain_008_001.ChargeBearerType1Code;
import iso.std.iso._20022.tech.xsd.pain_008_001.CustomerDirectDebitInitiationV02;
import iso.std.iso._20022.tech.xsd.pain_008_001.DirectDebitTransaction6;
import iso.std.iso._20022.tech.xsd.pain_008_001.DirectDebitTransactionInformation9;
import iso.std.iso._20022.tech.xsd.pain_008_001.Document;
import iso.std.iso._20022.tech.xsd.pain_008_001.GroupHeader39;
import iso.std.iso._20022.tech.xsd.pain_008_001.LocalInstrument2Choice;
import iso.std.iso._20022.tech.xsd.pain_008_001.MandateRelatedInformation6;
import iso.std.iso._20022.tech.xsd.pain_008_001.ObjectFactory;
import iso.std.iso._20022.tech.xsd.pain_008_001.PaymentInstructionInformation4;
import iso.std.iso._20022.tech.xsd.pain_008_001.PaymentMethod2Code;
import iso.std.iso._20022.tech.xsd.pain_008_001.PaymentTypeInformation20;
import iso.std.iso._20022.tech.xsd.pain_008_001.Purpose2Choice;
import iso.std.iso._20022.tech.xsd.pain_008_001.SequenceType1Code;
import iso.std.iso._20022.tech.xsd.pain_008_001.ServiceLevel8Choice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.joda.time.LocalDate;


/**
 * This document describes the Implementation Guidelines for the XML SEPA Direct Debit Initiation message
 * UNIFI (ISO20022) - “pain.008.001.02” in the Netherlands.
 */
public class DirectDebitPainFile extends BasePainFile {

    private final Document document = new Document();
    private final CustomerDirectDebitInitiationV02 customerDirectDebitInitiationV02;
    private GroupHeader39 groupHeader;


    public CreditorInfoJsonObjectMapper getCreditorInfo() {
        return creditorInfo;
    }

    public void setCreditorInfo(CreditorInfoJsonObjectMapper creditorInfo) {
        this.creditorInfo = creditorInfo;
    }

    private CreditorInfoJsonObjectMapper creditorInfo;

    public DirectDebitPainFile(ConfigurationService configurationService1) {
        customerDirectDebitInitiationV02 = new CustomerDirectDebitInitiationV02();
        document.setCstmrDrctDbtInitn(customerDirectDebitInitiationV02);
        configurationService = configurationService1;
    }

    /**
     * Set of characteristics shared by all individual transactions included in the message.
     *
     * @param msgId Point to point reference, assigned by the instructing party and sent to
     *              the next party in the chain, to unambiguously identify the message.
     * @param name
     * @param date
     */
    public void buildGroupHeader(String msgId, String name, Date date) {
        groupHeader = new GroupHeader39();

        // if no msgId is given create one
        if (msgId == null)
            msgId = UUID.randomUUID().toString().replaceAll("-", "");
        checkArgument(msgId.length() <= 35, "length of setMsgId is more than 35");
        checkArgument(msgId.length() > 1, "length of setMsgId is less than 1");
        groupHeader.setMsgId(msgId);

        // Date and time at which the message was created.
        groupHeader.setCreDtTm(createXMLGregorianCalendar(date));

        // Number of individual transactions contained in the message.
        groupHeader.setNbOfTxs("0");

        //Total of all individual amounts included in the message.
        groupHeader.setCtrlSum(BigDecimal.ZERO);

        // Party that initiates the payment.
        groupHeader.setInitgPty(createParty(name));

        customerDirectDebitInitiationV02.setGrpHdr(groupHeader);
    }


    public PaymentInstruction paymentInstruction(
            String pmtInfId, Date reqdColltnDt,
            String creditor, SequenceType1Code type,
            String creditorCountry, List<String> addressLines,
            String creditorAccount, String creditorBic) {

        PaymentInstruction paymentInstruction = new PaymentInstruction(
                pmtInfId, reqdColltnDt,
                creditor, type,
                creditorCountry, addressLines,
                creditorAccount, creditorBic);
        this.customerDirectDebitInitiationV02.getPmtInf().add(paymentInstruction.getPaymentInstructionInformation());
        return paymentInstruction;
    }

    public void write(String filePath) throws JAXBException, FileNotFoundException {
        File file = new File(filePath + "008.001.002.xml");
        OutputStream os = new FileOutputStream(file);
        //	JAXBContext jc = JAXBContext.newInstance(Document.class);
        JAXBContext jc = JAXBContext.newInstance("iso.std.iso._20022.tech.xsd.pain_008_001");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // The UTF-8 character encoding standard must be used in the UNIFI messages.
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(new ObjectFactory().createDocument(document), os);
    }

    public PaymentInstruction paymentInstruction(
            CreditorInfo creditorInfo, DirectDebitRequestData directDebitRequestData) throws Exception {
        List<String> addressLines = com.henripay.sepadd.iso20022.sepa.Utils.toAdressLines(creditorInfo.getAccountInfo().getAddress());
        String IBAN = creditorInfo.getAccountInfo().getIBAN();
        if (!IBAN.isEmpty()) {
            String bic = getBIC(IBANUtils.getBankCode(IBAN));
            PaymentInstruction paymentInstruction = new PaymentInstruction(
                    directDebitRequestData.getEndToEndTransactionReference() /* change this */, Date.from(directDebitRequestData.getScheduledExecutionDate().toInstant()),
                    creditorInfo.getAccountInfo().getName(), SequenceType1Code.fromValue(directDebitRequestData.getTransactionType().getValue()),
                    IBANUtils.getCountry(IBAN), addressLines, IBAN, bic);

            this.customerDirectDebitInitiationV02.getPmtInf().add(paymentInstruction.getPaymentInstructionInformation());
            return paymentInstruction;
        }
        throw new Exception("Missing IBAN field");
    }

    public class PaymentInstruction {

        private final PaymentInstructionInformation4 paymentInstructionInformation;

        /**
         * @param pmtInfId
         * @param reqdColltnDt Date and time at which the creditor requests that the amount of money is to be
         *                     collected from the debtor.
         */
        public PaymentInstruction(
                String pmtInfId, Date reqdColltnDt,
                String creditor, SequenceType1Code type,
                String creditorCountry, List<String> addressLines,
                String creditorAccount, String creditorBic) {

            paymentInstructionInformation = new PaymentInstructionInformation4();

            // Unique identification, as assigned by a sending party, to
            // unambiguously identify the payment information group within the message.
            checkArgument(pmtInfId.length() <= 35, "length of pmtInfId is more than 35");
            checkArgument(pmtInfId.length() > 1, "length of pmtInfId is less than 1");
            paymentInstructionInformation.setPmtInfId(pmtInfId);

            // Specifies the means of payment that will be used to move the amount of money.
            // DD=DirectDebit
            paymentInstructionInformation.setPmtMtd(PaymentMethod2Code.DD);

            // TODO
            paymentInstructionInformation.setNbOfTxs("0");

            // TODO
            paymentInstructionInformation.setCtrlSum(BigDecimal.ZERO);

            // TODO
            paymentInstructionInformation.setPmtTpInf(makePaymentTypeInformation(type));

            // Date and time at which the creditor requests that the amount of money is to be
            // collected from the debtor.
            paymentInstructionInformation.setReqdColltnDt(createXMLGregorianCalendarDate(reqdColltnDt));

            // Party to which an amount of money is due.
            paymentInstructionInformation.setCdtr(createParty(creditor, creditorCountry, addressLines));
            // Unambiguous identification of the account of the creditor to which a credit entry will
            // be posted as a result of the payment transaction. Only IBAN is allowed.
            paymentInstructionInformation.setCdtrAcct(createAccount(creditorAccount));

            paymentInstructionInformation.setCdtrAgt(createFinInstnId(creditorBic));

            paymentInstructionInformation.setChrgBr(ChargeBearerType1Code.SLEV);

        }


        public DirectDebitTransactionInformation9 addTransaction(
                DirectDebitRequestData directDebitRequestData) {
            DirectDebitTransactionInformation9 directDebitTransactionInformation = new DirectDebitTransactionInformation9();

            // Set of elements used to reference a payment instruction.
            directDebitTransactionInformation.setPmtId(createPaymentIdentification(directDebitRequestData.getEndToEndTransactionReference() /*change this */, directDebitRequestData.getEndToEndTransactionReference()));

            // Amount of money to be moved between the debtor and creditor, before deduction
            // of charges, expressed in the currency as ordered by the initiating party.
            directDebitTransactionInformation.setInstdAmt(createAmount(directDebitRequestData.getAmount()));

            //adding Mandate Information :
            Mandateinformation mandateinformation = directDebitRequestData.getMandateInformation();
            if (mandateinformation != null) {
                directDebitTransactionInformation.setDrctDbtTx(t(mandateinformation.getMandateId(), LocalDate.fromDateFields(mandateinformation.getDateOfsignature()), mandateinformation.getPersonId()));
            }

            // adding Account infor
            if (!directDebitRequestData.getAccountInfo().getIBAN().isEmpty())
            // Financial institution servicing an account for the debtor.
            {
                String iban = directDebitRequestData.getAccountInfo().getIBAN();
                String bic = getBIC(IBANUtils.getBankCode(iban));

                directDebitTransactionInformation.setDbtrAgt(createFinInstnId(bic));
                // Party that owes an amount of money to the (ultimate) creditor.
                directDebitTransactionInformation.setDbtr(createParty(directDebitRequestData.getAccountInfo().getName()));
                directDebitTransactionInformation.setDbtrAcct(createAccount(directDebitRequestData.getAccountInfo().getIBAN()));

                //TODO:
                Purpose2Choice purpose = new Purpose2Choice();
                purpose.setCd("OTHR");
                directDebitTransactionInformation.setPurp(purpose);
            }

            // TODO later if needed
            //directDebitTransactionInformation.setRmtInf( createRmtInf(directDebitRequestData.getRemittanceInfo) );

            paymentInstructionInformation.getDrctDbtTxInf().add(directDebitTransactionInformation);

            // TODO:
            BigDecimal ctrlSum = groupHeader.getCtrlSum();
            ctrlSum = ctrlSum.add(directDebitRequestData.getAmount());
            groupHeader.setCtrlSum(ctrlSum);

            int nbOfTxs = Integer.parseInt(groupHeader.getNbOfTxs());
            nbOfTxs = nbOfTxs + 1;
            groupHeader.setNbOfTxs(String.valueOf(nbOfTxs));

            // TODO:
            BigDecimal ictrlSum = paymentInstructionInformation.getCtrlSum();
            ictrlSum = ictrlSum.add(directDebitRequestData.getAmount());
            paymentInstructionInformation.setCtrlSum(ictrlSum);

            int inbOfTxs = Integer.parseInt(paymentInstructionInformation.getNbOfTxs());
            inbOfTxs = inbOfTxs + 1;
            paymentInstructionInformation.setNbOfTxs(String.valueOf(inbOfTxs));


            return directDebitTransactionInformation;
        }

        public PaymentInstructionInformation4 getPaymentInstructionInformation() {
            return paymentInstructionInformation;
        }


        private PaymentTypeInformation20 makePaymentTypeInformation(SequenceType1Code type) {
            // Payment Type Information
            PaymentTypeInformation20 paymentTypeInformation = new PaymentTypeInformation20();

            ServiceLevel8Choice serviceLevel8Choice = new ServiceLevel8Choice();
            serviceLevel8Choice.setCd("SEPA");//Vaste waarde 'SEPA'
            paymentTypeInformation.setSvcLvl(serviceLevel8Choice);

            LocalInstrument2Choice localInstrument = new LocalInstrument2Choice();
            localInstrument.setCd("CORE"); // "CORE" voor incasso's van particulieren
            paymentTypeInformation.setLclInstrm(localInstrument);

            //FRST eerste incasso binnen een serie op hetzelfde mandaat
            //RCUR vervolgincasso binnen hetzelfde mandaat
            //FNAL laatste incasso binnen hetzelfde mandaat
            //OOFF enkelvoudige incasso zonder repetering
            // Als de "Amendment indicator" (veld 2.50) op 'true' staat en de
            // "Original Debtor Agent"(veld 2.58) is "SMNDA" dan moet "FRST" gekozen	worden
            // Na een afwijzing van een "FRST" of "OOFF" moet een herhaling als "FRST" aangegeven worden
            // Als een "FRST" gestorneerd of geretourneerd wordt (alleen bij type "CORE") moet deze als "RCUR" ingestuurd worden
            // Als een "OOFF" gestorneerd of geretourneerd wordt (alleen bij type "CORE") kan deze alleen met een nieuw mandaat ingestuurd worden
            paymentTypeInformation.setSeqTp(type);

            return paymentTypeInformation;
        }

        private DirectDebitTransaction6 t(String mandateId, LocalDate dtOfSgntr, String cdtrSchmeId) {
            DirectDebitTransaction6 transaction = new DirectDebitTransaction6();

            MandateRelatedInformation6 mandateInf = new MandateRelatedInformation6();
            mandateInf.setMndtId(mandateId);
            mandateInf.setDtOfSgntr(createXMLGregorianCalendarDate(dtOfSgntr.toDate()));
            mandateInf.setAmdmntInd(false);
            transaction.setMndtRltdInf(mandateInf);

            ////
            transaction.setCdtrSchmeId(createIdParty(cdtrSchmeId));

            return transaction;
        }

    }
}
