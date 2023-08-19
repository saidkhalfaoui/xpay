package com.skwar.emvissuance.awsclient;

import com.skwar.emvissuance.model.KeyProfile;
import com.skwar.emvissuance.model.KmsKey;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;
import software.amazon.awssdk.awscore.AwsClient;
import software.amazon.awssdk.awscore.AwsRequest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.AwsRegionProviderChain;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;
import software.amazon.awssdk.services.paymentcryptography.PaymentCryptographyClient;
import software.amazon.awssdk.services.paymentcryptography.model.*;
import software.amazon.awssdk.services.paymentcryptography.PaymentCryptographyBaseClientBuilder;
import  software.amazon.awssdk.services.paymentcryptographydata.*;
import software.amazon.awssdk.services.paymentcryptographydata.model.*;


import java.net.http.HttpClient;


public class AWSRestClient  {
    // this is a simple AWS cloud payment cryptography to the API
    /*to put base URL in config file*/
    String baseURL = "https://controlplane.payment-cryptography.us-east-1.amazonaws.com";
    String CREATE_KEY_PATH = "/create-key";
    private PaymentCryptographyClient client;

    public AWSRestClient() {
        EnvironmentVariableCredentialsProvider credentials= EnvironmentVariableCredentialsProvider.create();
        client= PaymentCryptographyClient.builder().
                credentialsProvider(credentials).region(Region.US_EAST_1).build();
        System.out.println("client created:" + client.toString());
    }


    public String getURL(String path) {
        return baseURL + path;

    }


    public String getBaseURL() {
        return baseURL;
    }

    public KmsKey CreateKeyRequest(KeyProfile profile) {
      //  AwsRequest.Builder buildRequest= CreateKeyRequest.Builder(c
        // add parameters tp generate key
        KeyModesOfUse modeOfUse= KeyModesOfUse.builder().deriveKey(true).build();
        KeyAttributes keyAttributes =  KeyAttributes.builder().
                keyUsage("TR31_E0_EMV_MKEY_APP_CRYPTOGRAMS").
                keyModesOfUse(modeOfUse).
                keyAlgorithm("TDES_2KEY").
                keyClass("SYMMETRIC_KEY").build();



        CreateKeyRequest createKeyRequest= CreateKeyRequest.builder().
                keyAttributes(keyAttributes).
                enabled(true).
                exportable(profile.isExportable()).
                build();
        CreateKeyResponse response= client.createKey(createKeyRequest);
        System.out.println ("Key Genrated" + response.toString());
        KmsKey key= new KmsKey();
        key.setKeyArn(response.key().keyArn());
        key.setKeyValue(response.key().keyOriginAsString());
        return  key;

    }

    public ImportKeyRequest  CreateImportKeyRequest(KmsKey key, AWSConfigs config) {
        ImportKeyRequest buildRequest = software.amazon.awssdk.services.paymentcryptography.model.ImportKeyRequest.builder().build();
        // add parameters to import key

        return   buildRequest;


    }
}



    //[cloudshell-user@ip-10-6-28-103 ~]$ aws payment-cryptography create-key --exportable --key-attributes KeyAlgorithm=TDES_2KEY,KeyClass=SYMMETRIC_KEY,KeyModesOfUse="{DeriveKey=true}",KeyUsage="TR31_E0_EMV_MKEY_APP_CRYPTOGRAMS"
//{
//    "Key": {
//        "CreateTimestamp": "2023-08-07T08:05:08.932000+00:00",
//        "Enabled": true,
//        "Exportable": true,
//        "KeyArn": "arn:aws:payment-cryptography:us-east-1:419710311768:key/47ydm77emz4kk4ua",
//        "KeyAttributes": {
//            "KeyAlgorithm": "TDES_2KEY",
//            "KeyClass": "SYMMETRIC_KEY",
//            "KeyModesOfUse": {
//                "Decrypt": false,
//{
//    "Key": {
//        "CreateTimestamp": "2023-08-07T08:05:08.932000+00:00",
//        "Enabled": true,
//        "Exportable": true,
//        "KeyArn": "arn:aws:payment-cryptography:us-east-1:419710311768:key/47ydm77emz4kk4ua",
//        "KeyAttributes": {
//            "KeyAlgorithm": "TDES_2KEY",
//            "KeyClass": "SYMMETRIC_KEY",
//            "KeyModesOfUse": {
//                "Decrypt": false,
//                "DeriveKey": true,
//                "Encrypt": false,
//                "Generate": false,
//                "NoRestrictions": false,
//                "Sign": false,
//                "Unwrap": false,
//                "Verify": false,
//:
