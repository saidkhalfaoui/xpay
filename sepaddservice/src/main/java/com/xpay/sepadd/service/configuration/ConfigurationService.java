package com.xpay.sepadd.service.configuration;

import com.xpay.sepadd.dto.CreditorInfo;

public interface ConfigurationService {
    CreditorInfo getDefaultCreditorInfo();

    CreditorInfo getCreditorInfo(String name);

    String getBICfromBankCode(String bankCode);
}
