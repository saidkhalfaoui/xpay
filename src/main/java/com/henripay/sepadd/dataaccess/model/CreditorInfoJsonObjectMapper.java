package com.henripay.sepadd.dataaccess.model;

import com.henripay.sepadd.api.model.Accountinformation;

public class CreditorInfoJsonObjectMapper {

    private Accountinformation accountinformation;
    private String isDefault ;
    // add additional info

    public Accountinformation getAccountinformation() {
        return accountinformation;
    }

    public void setAccountinformation(Accountinformation accountinformation) {
        this.accountinformation = accountinformation;
    }
}
