package com.xpay.sepadd.helper;

import com.xpay.sepadd.dto.DirectDebitRequestData;
import org.jdom2.Document;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* To Be removed

 */
public class PaymentFileHelper {

    public static Document appendToDirectDebitFile(DirectDebitRequestData data) {
        return null;

    }

    public OutputStream createDirectDebitFile() throws FileNotFoundException {
        return new FileOutputStream("test");

    }

    public OutputStream signDirectDebitFile(byte[] directDebitUnsinged) throws FileNotFoundException {
        return new FileOutputStream("test");
    }
}