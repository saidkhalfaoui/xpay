package com.henripay.sepadd.dataaccess;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.henripay.sepadd.api.model.CreditorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class ConfigurationFireStoreDAO implements ConfigurationDAO {

    private static final String CREDITOR_INFO = "creditor-info";
    private static final String BIC = "BIC";
    Logger logger = LoggerFactory.getLogger(ConfigurationFireStoreDAO.class);
    @Autowired
    FireStoreDatabase fireStoreDatabase;
    private Firestore database;


    public Firestore getDatabase() {

        try {
            database = fireStoreDatabase.getDatabase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return database;

    }


    @Override
    public List<CreditorInfo> getCreditorInfoList() {
        database = getDatabase();
        CollectionReference ref = database.collection(CREDITOR_INFO);
        ApiFuture<QuerySnapshot> querySnapshot = ref.get();
        List<CreditorInfo> creditorInfoList = new ArrayList<>();
        try {
            for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
                // Access document data using document.toObject()
                System.out.println("Document ID: " + document.getId());
                creditorInfoList.add(document.toObject(CreditorInfo.class));

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return creditorInfoList;
    }

    @Override

    public String getBICfromCode(String bankCode) {
        database = getDatabase();

        CollectionReference ref = database.collection(BIC);
        ApiFuture<QuerySnapshot> querySnapshot = ref.get();
        List<CreditorInfo> creditorInfoList = new ArrayList<>();
        String bic;
        try {
            QueryDocumentSnapshot document = querySnapshot.get().getDocuments().get(0);
            // Access document data using document.toObject()
            System.out.println("BIC list ID: " + document.getId());


            bic = document.get(bankCode).toString();
            if (bic.isEmpty()) {
                logger.warn("BIC not found for this iban , returning empty string");
            }
            return bic;


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
