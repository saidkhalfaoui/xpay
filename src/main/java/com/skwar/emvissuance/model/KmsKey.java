package com.skwar.emvissuance.model;

public class KmsKey {
    private String keyId;
    private String keyArn;
    private String KeyProfileId;
    private String keyValue;
    private String keyCheckValue;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyArn() {
        return keyArn;
    }

    public void setKeyArn(String keyArn) {
        this.keyArn = keyArn;
    }

    @Override
    public String toString() {
        return "KmsKey{" +
                "keyId='" + keyId + '\'' +
                ", keyArn='" + keyArn + '\'' +
                '}';
    }


    public String getKeyProfileId() {
        return KeyProfileId;
    }

    public void setKeyProfileId(String keyProfileId) {
        KeyProfileId = keyProfileId;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyCheckValue() {
        return keyCheckValue;
    }

    public void setKeyCheckValue(String keyCheckValue) {
        this.keyCheckValue = keyCheckValue;
    }
}
