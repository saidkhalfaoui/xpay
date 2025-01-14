package com.xpay.sepadd.iso20022.sepa;

import com.xpay.sepadd.dto.Accountinformation;
import com.xpay.sepadd.dto.CreditTransferRequestData;
import com.xpay.sepadd.dto.CreditorInfo;
import com.xpay.sepadd.service.configuration.ConfigurationService;
import iso.std.iso._20022.tech.xsd.pain_001_001.*;
import org.joda.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.xpay.sepadd.iso20022.sepa.Utils.*;

/**
 * The Customer SEPA Credit Transfer Initiation message is sent by the initiating party to the debtor bank. It
 * is used to request movement of funds from the debtor account to a creditor account.
 * <p>
 * <p>
 * According to the Implementation Guidelines for the XML Customer Credit Transfer Initiation
 * message UNIFI (ISO20022) - "pain.001.001.03" in the Netherlands.
 */
public class CreditTransferPainFile extends BasePainFile {

    private final Document document = new Document();
    private final CustomerCreditTransferInitiationV03 customerCreditTransferInitiation;
    private GroupHeader32 groupHeader;

    public CreditTransferPainFile(ConfigurationService configurationService1) {
        customerCreditTransferInitiation = new CustomerCreditTransferInitiationV03();
        document.setCstmrCdtTrfInitn(customerCreditTransferInitiation);
        configurationService = configurationService1;
    }

    public void write(String filePath) throws JAXBException, FileNotFoundException {
        File file = new File(filePath + "001.001.003.xml");
        OutputStream os = new FileOutputStream(file);
        //	JAXBContext jc = JAXBContext.newInstance(Document.class);
        JAXBContext jc = JAXBContext.newInstance("iso.std.iso._20022.tech.xsd.pain_001_001");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // The UTF-8 character encoding standard must be used in the UNIFI messages.
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(new iso.std.iso._20022.tech.xsd.pain_001_001.ObjectFactory().createDocument(document), os);
    }

    /**
     * Group Header: This building block is mandatory and present once. It contains elements such as
     * Message Identification, Creation Date and Time, Grouping Indicator.
     * Set of characteristics shared by all individual transactions included in the message.
     *
     * @param msgId Point to point reference, as assigned by the instructing party
     * @param name  Name of the party that initiates the payment.
     * @throws DatatypeConfigurationException
     */
    public void buildGroupHeader(String msgId, String name, Date date) {
        groupHeader = new GroupHeader32();
        // Point to point reference, as assigned by the instructing party, and sent to the next
        // party in the chain to unambiguously identify the message.
        // The instructing party has to make sure that MessageIdentification is unique per
        // instructed party for a pre-agreed period.
        // if no msgId is given create one
        if (msgId == null)
            msgId = UUID.randomUUID().toString().replaceAll("-", "");
        checkArgument(msgId.length() <= 35, "length of msgId is more than 35");
        checkArgument(msgId.length() > 1, "length of msgId is less than 1");
        groupHeader.setMsgId(msgId);

        // Date and time at which the message was created.
        groupHeader.setCreDtTm(createXMLGregorianCalendar(date));

        // Number of individual transactions contained in the message.
        groupHeader.setNbOfTxs("0");

        //Total of all individual amounts included in the message.
        groupHeader.setCtrlSum(BigDecimal.ZERO);

        // Party that initiates the payment.
        groupHeader.setInitgPty(createParty(name));

        customerCreditTransferInitiation.setGrpHdr(groupHeader);
    }

    /**
     * Payment Information: This building block is mandatory and repetitive. It contains besides
     * elements related to the debit side of the transaction, such as Debtor and Payment Type
     * Information, also one or several Transaction Information Blocks.
     * <p>
     * Set of characteristics that applies to the debit side of the payment transactions
     * included in the credit transfer initiation.
     *
     * @param pmtInfId          Unique identification, as assigned by a sending party, to unambiguously identify the
     *                          payment information group within the message.
     * @param date              This is the date on which the debtor's account is to be debited.
     * @param debtorNm          Party that owes an amount of money to the (ultimate) creditor.
     * @param debtorAccountIBAN Unambiguous identification of the account of the debtor to which a debit
     *                          entry will be made as a result of the transaction.
     * @return
     * @throws DatatypeConfigurationException
     */
    public PaymentGroup paymentGroup(
            String pmtInfId, LocalDate reqdExctnDt,
            String debtorNm, String debtorAccountIBAN, String financialInstitutionBIC) {

        checkArgument(pmtInfId.length() <= 35, "length of pmtInfId is more than 35");
        checkArgument(pmtInfId.length() > 1, "length of pmtInfId is less than 1");


        PaymentInstructionInformation3 paymentInstructionInformation = new PaymentInstructionInformation3();
        //customerCreditTransferInitiation.getPmtInf().add(paymentInstructionInformation);

        // Unique identification, as assigned by a sending party, to unambiguously identify the
        // payment information group within the message.
        paymentInstructionInformation.setPmtInfId(pmtInfId);

        // Specifies the means of payment that will be used to move the amount of money.
        // Only ‘TRF’ is allowed.
        paymentInstructionInformation.setPmtMtd(PaymentMethod3Code.TRF);

        // Number of individual transactions contained in the payment information group.
        paymentInstructionInformation.setNbOfTxs("0");

        // Total of all individual amounts included in the group
        paymentInstructionInformation.setCtrlSum(BigDecimal.ZERO);

        // Payment Type Information
        PaymentTypeInformation19 paymentTypeInformation = new PaymentTypeInformation19();
        ServiceLevel8Choice serviceLevel8Choice = new ServiceLevel8Choice();
        serviceLevel8Choice.setCd("SEPA");//Vaste waarde 'SEPA'
        paymentTypeInformation.setSvcLvl(serviceLevel8Choice);
        paymentInstructionInformation.setPmtTpInf(paymentTypeInformation);

        // This is the date on which the debtor's account is to be debited.
        paymentInstructionInformation.setReqdExctnDt(createXMLGregorianCalendarDate(reqdExctnDt.toDate()));

        // Party that owes an amount of money to the (ultimate) creditor.
        paymentInstructionInformation.setDbtr(createParty(debtorNm));

        // Unambiguous identification of the account of the debtor to which a debit entry will be
        // made as a result of the transaction.
        paymentInstructionInformation.setDbtrAcct(createAccount(debtorAccountIBAN));

        // Financial institution servicing an account for the debtor.
        paymentInstructionInformation.setDbtrAgt(createFinInstnId(financialInstitutionBIC));

        paymentInstructionInformation.setChrgBr(ChargeBearerType1Code.SLEV);

        customerCreditTransferInitiation.getPmtInf().add(paymentInstructionInformation);

        return new PaymentGroup(paymentInstructionInformation);
    }


    public PaymentGroup paymentGroup(
            CreditorInfo debitorInfo, CreditTransferRequestData creditTransferRequestData) {
        String pmtInfId = creditTransferRequestData.getEndToEndTransactionReference();
        checkArgument(pmtInfId.length() <= 35, "length of pmtInfId is more than 35");
        checkArgument(pmtInfId.length() > 1, "length of pmtInfId is less than 1");


        PaymentInstructionInformation3 paymentInstructionInformation = new PaymentInstructionInformation3();
        //customerCreditTransferInitiation.getPmtInf().add(paymentInstructionInformation);

        // Unique identification, as assigned by a sending party, to unambiguously identify the
        // payment information group within the message.
        paymentInstructionInformation.setPmtInfId(pmtInfId);

        // Specifies the means of payment that will be used to move the amount of money.
        // Only ‘TRF’ is allowed.
        paymentInstructionInformation.setPmtMtd(PaymentMethod3Code.TRF);

        // Number of individual transactions contained in the payment information group.
        paymentInstructionInformation.setNbOfTxs("0");

        // Total of all individual amounts included in the group
        paymentInstructionInformation.setCtrlSum(BigDecimal.ZERO);

        // Payment Type Information
        PaymentTypeInformation19 paymentTypeInformation = new PaymentTypeInformation19();
        ServiceLevel8Choice serviceLevel8Choice = new ServiceLevel8Choice();
        serviceLevel8Choice.setCd("SEPA");//Vaste waarde 'SEPA'
        paymentTypeInformation.setSvcLvl(serviceLevel8Choice);
        paymentInstructionInformation.setPmtTpInf(paymentTypeInformation);

        // This is the date on which the debtor's account is to be debited.
        paymentInstructionInformation.setReqdExctnDt(createXMLGregorianCalendarDate(Date.from(creditTransferRequestData.getScheduledExecutionDate().atZone(ZoneId.systemDefault()).toInstant())));

        // Party that owes an amount of money to the (ultimate) creditor.


        // Unambiguous identification of the account of the debtor to which a debit entry will be
        // made as a result of the transaction.
        Accountinformation accountinformation = debitorInfo.getAccountInfo();
        if (accountinformation != null) {
            String iban = accountinformation.getIBAN();
            if (!iban.isEmpty()) {
                String bic = getBIC(IBANUtils.getBankCode(iban));
                paymentInstructionInformation.setDbtrAcct(createAccount(iban));
                paymentInstructionInformation.setDbtrAgt(createFinInstnId(bic));
            }
            paymentInstructionInformation.setDbtr(createParty(accountinformation.getName()));
        }


        // Financial institution servicing an account for the debtor.


        paymentInstructionInformation.setChrgBr(ChargeBearerType1Code.SLEV);

        customerCreditTransferInitiation.getPmtInf().add(paymentInstructionInformation);

        return new PaymentGroup(paymentInstructionInformation);
    }


    public class PaymentGroup {

        private final PaymentInstructionInformation3 paymentInstructionInformation3;

        public PaymentGroup(PaymentInstructionInformation3 paymentInstructionInformation3) {
            this.paymentInstructionInformation3 = paymentInstructionInformation3;
        }

        /**
         * Set of elements used to provide information on the individual transaction(s) included in the message.
         *
         * @param endToEndId                      Unique identification assigned by the initiating party to unambiguously identify the
         *                                        transaction. This identification is passed on, unchanged, throughout the entire end-to-end chain. maxLength: 35
         * @param amount                          Amount of money to be moved between the debtor and creditor, before deduction of
         *                                        charges, expressed in the currency as ordered by the initiating party.
         * @param creditorfinancialInstitutionBic Financial institution servicing an account for the creditor.
         * @param creditorNm                      Party to which an amount of money is due.
         * @param iban                            Unambiguous identification of the account of the creditor to which a credit entry will
         *                                        be posted as a result of the payment transaction.
         * @return
         */
	/*	public PaymentGroup creditTransfer(String endToEndId, BigDecimal amount,
										   String creditorfinancialInstitutionBic,
										   String creditorNm, String iban,
										   String text) {
			
			CreditTransferTransactionInformation10 creditTransferTransactionInformation 
				= new CreditTransferTransactionInformation10();
			
			// Unique identification as assigned by an instructing party for an instructed party to
			// unambiguously identify the instruction.
			PaymentIdentification1 paymentIdentification = new PaymentIdentification1();
			paymentIdentification.setEndToEndId(endToEndId);
			creditTransferTransactionInformation.setPmtId(paymentIdentification);
			
			// Amount of money to be moved between the debtor and creditor, before deduction of 
			// charges, expressed in the currency as ordered by the initiating party.
			creditTransferTransactionInformation.setAmt( createAmount(amount) );
			
			// Only 'SLEV' is allowed. 
			//creditTransferTransactionInformation.setChrgBr(ChargeBearerType1Code.SLEV);
			
			// Financial institution servicing an account for the creditor.
			creditTransferTransactionInformation.setCdtrAgt( createFinInstnId(creditorfinancialInstitutionBic) );
			
			// Party to which an amount of money is due.
			creditTransferTransactionInformation.setCdtr( createParty(creditorNm) );
			
			// Unambiguous identification of the account of the creditor to which a credit entry will
			// be posted as a result of the payment transaction.
			creditTransferTransactionInformation.setCdtrAcct( createAccount(iban) );
			
			creditTransferTransactionInformation.setRmtInf( createRmtInf(text) );
			
			paymentInstructionInformation3.getCdtTrfTxInf().add(creditTransferTransactionInformation);
			
			// Control sum
			paymentInstructionInformation3.setCtrlSum( paymentInstructionInformation3.getCtrlSum().add(amount) );
			groupHeader.setCtrlSum( groupHeader.getCtrlSum().add(amount) );
			
			// Number of transactions
			paymentInstructionInformation3.setNbOfTxs( String.valueOf(paymentInstructionInformation3.getCdtTrfTxInf().size()) );
			Integer nbOfTxs = Integer.parseInt(groupHeader.getNbOfTxs());
			nbOfTxs = nbOfTxs + 1;
			groupHeader.setNbOfTxs(nbOfTxs.toString());
			
			return this;
		}
*/
        public PaymentGroup addTransaction(CreditTransferRequestData creditTransferRequestData) {

            CreditTransferTransactionInformation10 creditTransferTransactionInformation
                    = new CreditTransferTransactionInformation10();

            // Unique identification as assigned by an instructing party for an instructed party to
            // unambiguously identify the instruction.
            PaymentIdentification1 paymentIdentification = new PaymentIdentification1();
            paymentIdentification.setEndToEndId(creditTransferRequestData.getEndToEndTransactionReference());
            creditTransferTransactionInformation.setPmtId(paymentIdentification);

            // Amount of money to be moved between the debtor and creditor, before deduction of
            // charges, expressed in the currency as ordered by the initiating party.
            creditTransferTransactionInformation.setAmt(createAmount(creditTransferRequestData.getAmount()));

            // Only 'SLEV' is allowed.
            //creditTransferTransactionInformation.setChrgBr(ChargeBearerType1Code.SLEV);

            // Financial institution servicing an account for the creditor.
            Accountinformation accountinformation = creditTransferRequestData.getAccountInfo();
            if (accountinformation != null) {
                String iban = creditTransferRequestData.getAccountInfo().getIBAN();
                if (!iban.isEmpty()) {
                    String bic = getBIC(IBANUtils.getBankCode(iban));

                    creditTransferTransactionInformation.setCdtrAgt(createFinInstnId(bic));

                    // Party to which an amount of money is due.


                    // Unambiguous identification of the account of the creditor to which a credit entry will
                    // be posted as a result of the payment transaction.
                    creditTransferTransactionInformation.setCdtrAcct(createAccount(iban));


                }
                creditTransferTransactionInformation.setCdtr(createParty(accountinformation.getName()));
            }


            creditTransferTransactionInformation.setRmtInf(createRmtInf(creditTransferRequestData.getRemittanceInfo()));

            paymentInstructionInformation3.getCdtTrfTxInf().add(creditTransferTransactionInformation);

            // Control sum
            paymentInstructionInformation3.setCtrlSum(paymentInstructionInformation3.getCtrlSum().add(creditTransferRequestData.getAmount()));
            groupHeader.setCtrlSum(groupHeader.getCtrlSum().add(creditTransferRequestData.getAmount()));

            // Number of transactions
            paymentInstructionInformation3.setNbOfTxs(String.valueOf(paymentInstructionInformation3.getCdtTrfTxInf().size()));
            Integer nbOfTxs = Integer.parseInt(groupHeader.getNbOfTxs());
            nbOfTxs = nbOfTxs + 1;
            groupHeader.setNbOfTxs(nbOfTxs.toString());

            return this;
        }

    }

}
