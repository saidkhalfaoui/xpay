package com.henripay.sepadd.dataaccess;

import com.henripay.sepadd.api.model.CreditorInfo;

import java.util.List;

public interface ConfigurationDAO {

    List<CreditorInfo> getCreditorInfoList();

    String getBICfromCode(String bankCode);
}
