package com.xpay.sepadd.iso20022.sepa;


import iso.std.iso._20022.tech.xsd.camt_053_001.AccountInterest2;
import iso.std.iso._20022.tech.xsd.camt_053_001.AccountStatement2;
import iso.std.iso._20022.tech.xsd.camt_053_001.BankToCustomerStatementV02;
import iso.std.iso._20022.tech.xsd.camt_053_001.CashAccount16;
import iso.std.iso._20022.tech.xsd.camt_053_001.CashAccount20;
import iso.std.iso._20022.tech.xsd.camt_053_001.CashBalance3;
import iso.std.iso._20022.tech.xsd.camt_053_001.CopyDuplicate1Code;
import iso.std.iso._20022.tech.xsd.camt_053_001.Document;
import iso.std.iso._20022.tech.xsd.camt_053_001.GroupHeader42;
import iso.std.iso._20022.tech.xsd.camt_053_001.Pagination;
import iso.std.iso._20022.tech.xsd.camt_053_001.PartyIdentification32;
import iso.std.iso._20022.tech.xsd.camt_053_001.ReportEntry2;
import iso.std.iso._20022.tech.xsd.camt_053_001.ReportingSource1Choice;
import iso.std.iso._20022.tech.xsd.camt_053_001.TotalTransactions2;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.google.common.collect.Lists;


/**
 * ISO20022 - "camt.053.001.02" in the Netherlands.
 *
 * @author "Jasper Krijgsman <jasper@irp.nl>"
 */
public class BankToCustomerStatement {

    private final Document document;
    private final BankToCustomerStatementV02 bankToCustomerStatement;
    private final GroupHeader42 groupHeader;

    private BankToCustomerStatement(Document document) {
        this.document = document;
        this.bankToCustomerStatement = document.getBkToCstmrStmt();
        this.groupHeader = bankToCustomerStatement.getGrpHdr();
    }

    public static BankToCustomerStatement read(InputStream is) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        // The UTF-8 character encoding standard must be used in the UNIFI messages.
        //unmarshaller.setProperty(Unm .JAXB_ENCODING, "UTF-8");

        StreamSource streamSource = new StreamSource(is);
        JAXBElement<Document> root = unmarshaller.unmarshal(streamSource, Document.class);

        return new BankToCustomerStatement(root.getValue());
    }

    /**
     * Returns the point to point reference, as assigned by the account servicing institution, and sent to the account
     * owner or the party authorised to receive the message, to unambiguously identify the message.
     */
    public String getMsgId() {
        return groupHeader.getMsgId();
    }

    /**
     * Returns the date and time at which the message was created.
     */
    public Date getCreDtTm() {
        return groupHeader.getCreDtTm().toGregorianCalendar().getTime();
    }

    /**
     * Returns the party authorised by the account owner to receive information about
     * movements on the account.
     */
    public PartyIdentification32 getMsgRcpt() {
        return groupHeader.getMsgRcpt();
    }

    /**
     * Returns a set of elements used to provide details on the page number of the message.
     */
    public Pagination getMsgPgntn() {
        return groupHeader.getMsgPgntn();
    }

    /**
     * Returns additionalInformation, further details of the message.
     * maxLength: 500
     */
    public String getAddtlInf() {
        return groupHeader.getAddtlInf();
    }

    /**
     * Returns reports on booked entries and balances for a cash account.
     */
    public List<AccountStatement> getStmt() {
        List<AccountStatement> accountStatements = Lists.newArrayList();
        for (AccountStatement2 accountStatement : bankToCustomerStatement.getStmt())
            accountStatements.add(new AccountStatement(accountStatement));
        return accountStatements;
    }

    public class AccountStatement {
        private final AccountStatement2 stmt;

        public AccountStatement(AccountStatement2 stmt) {
            this.stmt = stmt;
        }

        /**
         * Unique identification, as assigned by the account servicer, to unambiguously identify the account
         * statement.
         */
        public String getId() {
            return stmt.getId();
        }

        /**
         * Sequential number of the statement, as assigned by the account servicer.
         * The sequential number is increased incrementally for each statement sent electronically.
         */
        public BigDecimal getElctrncSeqNb() {
            return stmt.getElctrncSeqNb();
        }

        /**
         * Legal sequential number of the statement, as assigned by the account servicer. It is increased
         * incrementally for each statement sent.
         * <p>
         * Where a paper statement is a legal requirement, it may have a number different from the electronic
         * sequential number. Paper statements could for instance only be sent if movement on the account has
         * taken place, whereas electronic statements could be sent at the end of each reporting period,
         * regardless of whether movements have taken place or not.
         */
        public BigDecimal getLglSeqNb() {
            return stmt.getLglSeqNb();
        }

        /**
         * Date and time at which the message was created.
         */
        public Date getCreDtTm() {
            return stmt.getCreDtTm().toGregorianCalendar().getTime();
        }

        /**
         * Start date of the period for which the account statement is issued.
         */
        public Date getFrDt() {
            return stmt.getFrToDt().getFrDtTm().toGregorianCalendar().getTime();
        }

        /**
         * End date of the period for which the account statement is issued.
         */
        public Date getToDt() {
            return stmt.getFrToDt().getToDtTm().toGregorianCalendar().getTime();
        }

        /**
         * Indicates whether the document is a copy, a duplicate, or a duplicate of a copy.
         * <dl>
         * <dt>CODU</dt>
         * <dd>Message is being sent as a copy to a party other than the account owner,
         * for information purposes and the message is a duplicate of a message
         * previously sent.</dd>
         * <dt>COPY</dt>
         * <dd>Message is being sent as a copy to a party other than the account owner,
         * for information purposes</dd>
         * <dt>DUPL</dt>
         * <dd>Message is for information/confirmation purposes. It is a duplicate of a
         * message previously sent.</dd>
         * </dl>
         */
        public CopyDuplicate1Code getCpyDplctInd() {
            return stmt.getCpyDplctInd();
        }

        /**
         * ReportingSource
         * Specifies the application used to generate the reporting.
         *
         * @return
         */
        public ReportingSource1Choice getRptgSrc() {
            return stmt.getRptgSrc();
        }

        /**
         * Unambiguous identification of the account to which credit and debit entries are made.
         */
        public CashAccount20 getAcct() {
            return stmt.getAcct();
        }

        public CashAccount16 getRltdAcct() {
            return stmt.getRltdAcct();
        }

        public List<AccountInterest2> getIntrst() {
            return stmt.getIntrst();
        }

        public List<CashBalance3> getBal() {
            return stmt.getBal();
        }

        public TotalTransactions2 getTxsSummry() {
            return stmt.getTxsSummry();
        }

        public List<ReportEntry2> getNtry() {
            return stmt.getNtry();
        }

        public String getAddtlStmtInf() {
            return stmt.getAddtlStmtInf();
        }


    }

}
