package com.henripay.sepadd.dataaccess.config;

import com.henripay.sepadd.dto.CreditorInfo;

import java.util.List;

public interface ConfigurationDAO {

    List<CreditorInfo> getCreditorInfoList();

    String getBICfromCode(String bankCode);
}
