package com.xpay.sepadd.iso20022.sepa;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;


public class IBANUtils {


    /**
     * Format the code as a human readable string.
     * The IBAN should not contain spaces when transmitted electronically.
     * However, when printed on paper, the IBAN is expressed in groups of four characters
     * separated by a single space, the last group being of variable length.
     * <code>GB29 NWBK 6016 1331 9268 19</code>
     *
     * @param iban
     * @return
     */
    public static String makeReadable(String iban) {
        Iterable<String> parts = Splitter.fixedLength(4).split(iban);
        return Joiner.on(" ").join(parts);
    }


    public static String clean(String iban) {
        // remove any strange characters
        iban = removeNonAlpha(iban);
        validate(iban);
        return iban;
    }

    public static boolean validate(String iban) {

        // Check ISO 3166-1 country code
        final String country = iban.substring(0, 2);
        return StringUtils.isAlpha(country);
        //if (!ISOCountries.getInstance().isValidCode(country)) {
        //	this.invalidCause = "Invalid ISO country code: "+country;
        //	return false;
        //}


        //The basis of the IBAN validation is to convert the IBAN into a number and to perform a basic
        //Mod-97 calculation (as described in ISO 7064) on it. If the IBAN is valid, then the remainder
        //equals 1. Rule process of IBAN validation is:
        //Check that the total IBAN length is correct as per the country. If not, the IBAN is invalid.
        //Move the four initial characters to the end of the string.
        //Replace each letter in the string with two digits, thereby expanding the string, where A=10, B=11, ..., Z=35.
        //Interpret the string as a decimal integer and compute the remainder of that number on division by 97.
		/*
		final StringBuffer bban = new StringBuffer(code.substring(4));
		if (bban.length()==0) {
			this.invalidCause="Empty Basic Bank Account Number";
			return false;
		}
		*/

        //ISO 7064,
    }

    public static String removeNonAlpha(final String iban) {
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < iban.length(); i++) {
            char c = iban.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Translate letters to numbers, also ignoring non alphanumeric characters
     *
     * @param bban
     * @return the translated value
     */
    public String translateChars(final StringBuffer bban) {
        final StringBuffer result = new StringBuffer();
        for (int i = 0; i < bban.length(); i++) {
            char c = bban.charAt(i);
            if (Character.isLetter(c)) {
                result.append(Character.getNumericValue(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static final Pattern ibanRegex =
            Pattern.compile("[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}");


    public static String getBankCode(String iban) {
        if (iban.length() >= 8) {
            return iban.substring(4, 8);
        }
        return null;

    }

    public static String getCountry(String iban) {
        if (iban.length() >= 8) {
            return iban.substring(0, 2);
        }
        return null;

    }


}

