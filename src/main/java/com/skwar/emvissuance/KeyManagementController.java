package com.skwar.emvissuance;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skwar.emvissuance.awsclient.AWSRestClient;
import com.skwar.emvissuance.model.KeyProfile;
import com.skwar.emvissuance.model.KmsKey;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keys")
public class KeyManagementController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public  AWSRestClient  awsRestClient=new AWSRestClient();
    @PostMapping("/generateKey")
    public ResponseEntity<String> generateKey(@RequestBody String  keyProfileJson) {
        // Generate keyHandle based on keyProfile
        KeyProfile keyProfile = null;
        try {
            keyProfile = objectMapper.readValue(keyProfileJson, KeyProfile.class);
        } catch (JsonProcessingException e) {
            System.out.println("something went wrong during parsing keyprofile");
            throw new RuntimeException(e);
        }
        String keyHandle = generateKeyHandle(keyProfile);

        return new ResponseEntity<>(keyHandle, HttpStatus.OK);
    }

    @PostMapping("/importKey")
    public ResponseEntity<String> importKey(@RequestBody String keyJson) {
        // Import key based on provided Key object
        KmsKey key = null;
        try {
            key = objectMapper.readValue(keyJson, KmsKey.class);
        } catch (JsonProcessingException e) {
            System.out.println("something went wrong during parsing key");
            throw new RuntimeException(e);
        }
        String keyHandle = importKeyHandle(key);

        return new ResponseEntity<>(keyHandle, HttpStatus.OK);
    }

    private String generateKeyHandle(KeyProfile keyProfile) {
        // Implement the logic to generate a key handle
        // This could involve some processing based on keyProfile
        //call awsclient to generate key
        AWSRestClient awsRestClient1= new AWSRestClient();
        KmsKey key= awsRestClient1.CreateKeyRequest(keyProfile);
        return key.toString();
    }

    private String importKeyHandle(KmsKey key) {
        // Implement the logic to import a key and generate a key handle
        // This could involve some processing based on the provided key
        return "ImportedKeyHandle";
    }
}




