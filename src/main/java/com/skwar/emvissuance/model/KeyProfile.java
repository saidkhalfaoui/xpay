package com.skwar.emvissuance.model;

public class KeyProfile {
    private  String profileName;
    private String keyLength;
    private String keyAlgorithm;
    private String keyType;
    private String[] keyUsages;
    private String keyUsage;
    private  boolean exportable;

    public boolean isExportable() {
        return exportable;
    }
    public void setExportable(boolean exportable) {
        this.exportable=exportable;
    }


    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(String keyLength) {
        this.keyLength = keyLength;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String[] getKeyUsages() {
        return keyUsages;
    }

    public void setKeyUsages(String[] keyUsages) {
        this.keyUsages = keyUsages;
    }

    public String getKeyUsage() {
        return keyUsage;
    }

    public void setKeyUsage(String keyUsage) {
        this.keyUsage = keyUsage;
    }
}
