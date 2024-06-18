package com.xpay.sepadd.iso20022.sepa;


import com.xpay.sepadd.service.configuration.ConfigurationService;


public class BasePainFile {
    protected ConfigurationService configurationService;


    public String getBIC(String bankCode) {
        return configurationService.getBICfromBankCode(bankCode);
    }

}
