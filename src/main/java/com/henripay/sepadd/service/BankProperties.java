package com.henripay.sepadd.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;


public class BankProperties {

private String url ;
private String host;
private String port;
private String publicKey ;
private String sshKey ;
private String keyStoreLocation;

    public String getKeyStorePassphrase() {
        return keyStorePassphrase;
    }

    public void setKeyStorePassphrase(String keyStorePassphrase) {
        this.keyStorePassphrase = keyStorePassphrase;
    }

    private String keyStorePassphrase;


}
