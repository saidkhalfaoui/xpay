package com.xpay.sepadd.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class JobProperties {

    private int batchSize;
    private int numberOfRetries;
    private int timeout;

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries(int numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }


    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "name='" + batchSize + '\'' +
                ", host='" + +'\'' +
                ", timeout=" + timeout +
                '}';
    }
}