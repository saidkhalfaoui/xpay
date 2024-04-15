package com.henripay.sepadd.iso20022.sepa;

import com.henripay.sepadd.dto.Address;
import iso.std.iso._20022.tech.xsd.pain_001_001.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;

public class Utils {


    private static final Pattern bicRegex =
            Pattern.compile("([a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?)");

    public static XMLGregorianCalendar createXMLGregorianCalendar(Date currentDateTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(currentDateTime);

        XMLGregorianCalendar createDate;
        try {
            createDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            createDate.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
            createDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        return createDate;
    }

    public static XMLGregorianCalendar createXMLGregorianCalendarDate(Date currentDateTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(currentDateTime);

        XMLGregorianCalendar createDate;
        try {
            createDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        return createDate;
    }

    /**
     * Information supplied to enable the matching of an entry with the items that the
     * transfer is intended to settle, such as commercial invoices in an accounts' receivable
     * system
     * max length: 140
     *
     * @return
     */
    public static RemittanceInformation5 createRmtInf(String info) {
        checkArgument(info.length() <= 140); //maxLength: 140
        checkArgument(info.length() >= 1);   //minLength: 1

        RemittanceInformation5 remittanceInformation = new RemittanceInformation5();
        remittanceInformation.getUstrd().add(info);
        return remittanceInformation;
    }

    /**
     * Information supplied to enable the matching of an entry with the items that the
     * transfer is intended to settle, such as commercial invoices in an accounts' receivable
     * system
     * max length: 140
     *
     * @return
     */
    public static RemittanceInformation5 createRmtInf_struct(String ref) {
        checkArgument(ref.length() <= 35, "maxLength: 35");
        checkArgument(ref.length() >= 1, "minLength: 1");

        RemittanceInformation5 remittanceInformation = new RemittanceInformation5();
        StructuredRemittanceInformation7 structuredRemittanceInformation = new StructuredRemittanceInformation7();
        CreditorReferenceInformation2 creditorReferenceInformation = new CreditorReferenceInformation2();
        structuredRemittanceInformation.setCdtrRefInf(creditorReferenceInformation);

        // Only 'SCOR' is allowed.
        CreditorReferenceType2 creditorReferenceType = new CreditorReferenceType2();
        CreditorReferenceType1Choice creditorReferenceType1Choice = new CreditorReferenceType1Choice();
        creditorReferenceType1Choice.setCd(DocumentType3Code.SCOR);
        creditorReferenceType.setCdOrPrtry(creditorReferenceType1Choice);
        creditorReferenceInformation.setTp(creditorReferenceType);

        creditorReferenceInformation.setRef(ref);

        remittanceInformation.getStrd().add(structuredRemittanceInformation);
        return remittanceInformation;
    }

    /**
     * Unambiguous identification of a account
     *
     * @return
     */
    public static CashAccount16 createAccount(String iban) {
        //sepacheckArgument(ibanRegex.matcher(iban).matches(), "This doesn't look like a correct IBAN id '"+iban+"'");

        CashAccount16 account = new CashAccount16();
        AccountIdentification4Choice creditorAccountId = new AccountIdentification4Choice();
        // Only IBAN is allowed.
        creditorAccountId.setIBAN(iban);
        account.setId(creditorAccountId);
        return account;
    }

    public static CashAccount16 createAccount(String iban, String currency) {
        CashAccount16 account = createAccount(iban);
        account.setCcy(currency);
        return account;
    }

    public static PartyIdentification32 createParty(String nm) {
        PartyIdentification32 party = new PartyIdentification32();
        party.setNm(nm);
        return party;
    }

    public static BranchAndFinancialInstitutionIdentification4 createFinInstnId(String bic) {
        //checkArgument(bicRegex.matcher(bic).matches(), "This doesn't look like a correct BIC id '"+bic+"'");
        //
        BranchAndFinancialInstitutionIdentification4 creditorAgent = new BranchAndFinancialInstitutionIdentification4();
        FinancialInstitutionIdentification7 creditorfinancialInstitutionIdentification = new FinancialInstitutionIdentification7();
        // Only BIC is allowed.
        creditorfinancialInstitutionIdentification.setBIC(bic);
        creditorAgent.setFinInstnId(creditorfinancialInstitutionIdentification);
        return creditorAgent;
    }

    public static AmountType3Choice createAmount(BigDecimal amount) {
        AmountType3Choice amt = new AmountType3Choice();
        ActiveOrHistoricCurrencyAndAmount instdAmt = new ActiveOrHistoricCurrencyAndAmount();
        instdAmt.setValue(amount);
        instdAmt.setCcy("EUR");
        amt.setInstdAmt(instdAmt);
        return amt;
    }

    public static List<String> toAdressLines(Address address) {
        if (address == null) return null;
        List<String> addressList = new ArrayList<>();
        addressList.add(address.getStreetName() + " " + address.getStreetNumber());
        addressList.add(address.getCity());
        addressList.add(address.getZipcode());
        addressList.add(address.getCountry());
        return addressList;
    }

}
