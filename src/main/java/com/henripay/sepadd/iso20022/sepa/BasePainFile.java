package com.henripay.sepadd.iso20022.sepa;


import com.henripay.sepadd.service.configuration.ConfigurationService;
import iso.std.iso._20022.tech.xsd.pain_008_001.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;



public class BasePainFile {
    protected ConfigurationService configurationService;



    public String getBIC (String bankCode)
    {
        return configurationService.getBICfromBankCode(bankCode);
    }

}
