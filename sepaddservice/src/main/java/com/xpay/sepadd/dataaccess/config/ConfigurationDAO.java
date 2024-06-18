package com.xpay.sepadd.dataaccess.config;

import com.xpay.sepadd.dto.CreditorInfo;

import java.util.List;

public interface ConfigurationDAO {

    List<CreditorInfo> getCreditorInfoList();

    String getBICfromCode(String bankCode);
}
