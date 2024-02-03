package com.henripay.sepadd.service.configuration;

import com.henripay.sepadd.api.model.CreditorInfo;

public interface ConfigurationService {
    CreditorInfo getDefaultCreditorInfo();
    CreditorInfo getCreditorInfo(String name);
    String getBICfromBankCode(String bankCode);
}
