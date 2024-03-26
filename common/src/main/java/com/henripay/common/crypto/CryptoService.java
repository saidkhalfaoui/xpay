package com.henripay.common.crypto;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class CryptoService {

    private final KeyManagementServiceClient kmsClient;

    @Value("${crypto.googleKms.projectId}")
    private String projectId;

    @Value("${crypto.googleKms.location}")
    private String location;

    private String keyId;

    public CryptoService() throws IOException {
        this.kmsClient = KeyManagementServiceClient.create();
    }

    public void createKeyRing() throws IOException {
        String id = "my-asymmetric-signing-key";
        createKeyRing(projectId, location, id);
    }

    // Create a new key ring.
    public void createKeyRing(String projectId, String locationId, String id) throws IOException {
        // Initialize client that will be used to send requests. This client only
        // needs to be created once, and can be reused for multiple requests. After
        // completing all of your requests, call the "close" method on the client to
        // safely clean up any remaining background resources.
        try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
            // Build the parent name from the project and location.
            LocationName locationName = LocationName.of(projectId, locationId);

            // Build the key ring to create.
            KeyRing keyRing = KeyRing.newBuilder().build();

            // Create the key ring.
            KeyRing createdKeyRing = client.createKeyRing(locationName, id, keyRing);
            System.out.printf("Created key ring %s%n", createdKeyRing.getName());
        }
    }


    public String encryptData(String projectId, String location, String keyRing, String keyId, String plaintext) {
        CryptoKeyName keyName = CryptoKeyName.of(projectId, location, keyRing, keyId);
        byte[] plaintextBytes = plaintext.getBytes();
        ByteString plaintextByteString = ByteString.copyFrom(plaintextBytes);
        ByteString ciphertext = kmsClient.encrypt(keyName.toString(), plaintextByteString).getCiphertext();
        return Base64.getEncoder().encodeToString(ciphertext.toByteArray());
    }

    public String decryptData(String projectId, String location, String keyRing, String keyId, String ciphertext) {
        CryptoKeyName keyName = CryptoKeyName.of(projectId, location, keyRing, keyId);
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        ByteString ciphertextByteString = ByteString.copyFrom(ciphertextBytes);
        ByteString plaintext = kmsClient.decrypt(keyName.toString(), ciphertextByteString).getPlaintext();
        return plaintext.toStringUtf8();
    }

    public String calculateHash(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}
