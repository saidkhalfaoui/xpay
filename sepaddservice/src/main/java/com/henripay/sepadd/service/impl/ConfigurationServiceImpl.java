package com.henripay.sepadd.service.impl;

import com.henripay.sepadd.dataaccess.config.ConfigurationDAO;
import com.henripay.sepadd.dto.CreditorInfo;
import com.henripay.sepadd.service.configuration.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    @Autowired
    private ConfigurationDAO dao;


    @Override
    public String getBICfromBankCode(String bankCode) {
        return dao.getBICfromCode(bankCode);

    }


    @Override
    public CreditorInfo getDefaultCreditorInfo() {
        return dao.getCreditorInfoList().get(0);
    }

    @Override
    public CreditorInfo getCreditorInfo(String name) {

        // to improve this if needed
        List<CreditorInfo> creditorInfoList = dao.getCreditorInfoList();

        List<CreditorInfo> filteredCreditorInfoList = creditorInfoList.stream()
                .filter(creditorInfo -> creditorInfo.getAccountInfo().getName().equals(name))
                .collect(Collectors.toList());
        if (filteredCreditorInfoList.size() > 1 || filteredCreditorInfoList.size() == 0) {
            return null;
        }
        return filteredCreditorInfoList.get(0);
    }
}
