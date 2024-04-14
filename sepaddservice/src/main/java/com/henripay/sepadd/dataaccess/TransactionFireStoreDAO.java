package com.henripay.sepadd.dataaccess;


import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.dataaccess.model.TransactionJsonObjectMapper;
import com.henripay.sepadd.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;


@Component
public class TransactionFireStoreDAO implements TransactionDAO {

    private CollectionReference transactionCollection;

    @Autowired
    private FireStoreDatabase fireStoreDatabase;
    private Firestore database;

    Logger logger = LoggerFactory.getLogger(TransactionFireStoreDAO.class);

    public Firestore getDatabase() {

        try {
            database = fireStoreDatabase.getDatabase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return database;

    }

    @Override
    public String addTransaction(String id, String type, Map<String, Object> data) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {

        database = getDatabase();
        DocumentReference docRef = database.collection(type).document(id);
        try {
            WriteResult result = docRef.set(data).get();
            logger.info(result.getUpdateTime().toString());
            // lo result.getUpdateTime()
            //return  id;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
      /*  try {
            document.set(data).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        return id;

    }

 /* deprecated , replaced by more generic addTranascation
 @Override
    public String addCreditTransferTransaction(String id , Map<String, Object> data) {


        DocumentReference docRef = database.collection(TRANSACTION_COLLECTION).document("credit-transfer"+ id);


        data.put(TransactionJsonObjectMapper.IBAN, transaction.getAccountInfo().getIBAN());
        data.put(TransactionJsonObjectMapper.ADDRESS, transaction.getAccountInfo().getAddress());
        data.put(TransactionJsonObjectMapper.AMOUNT,transaction.getAmount());
        data.put(TransactionJsonObjectMapper.CREATION_DATE , Instant.now().toString());
        data.put (TransactionJsonObjectMapper.STATUS, Statusenum.CREATED);
        data.put(TransactionJsonObjectMapper.ProcessingStatus , Processingstatusenum.PENDING);
        data.put(TransactionJsonObjectMapper.LAST_UPDATED , Instant.now().toString());
        try {
            WriteResult result= docRef.set(data).get();

            logger.info(result.getUpdateTime().toString());


            // lo result.getUpdateTime()
            //return  id;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
      *//*  try {
            document.set(data).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*//*

        return id;
    }*/


    @Override
    public CreditTransferRequest[] queryCTTranasctions(int MaxNumber, String queryString) {
        return new CreditTransferRequest[0];
    }

    @Override
    public TransactionStatusResponse queryTransactionStatusByTransactionId(String transactionId, String type) {
        database = getDatabase();
        CollectionReference ref = database.collection(type);

        DocumentReference docRef1 = ref.document(transactionId);


        ApiFuture<DocumentSnapshot> querySnapshot1 = docRef1.get();


        TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
        transactionStatusResponse.setTransactionId(transactionId);

        try {

            DocumentSnapshot documentReference1 = querySnapshot1.get();
            if (documentReference1.exists()) {
                DirectDebitRequestData request = documentReference1.toObject(DirectDebitRequestData.class);  // to do , DirectDebitTransactionData and CreditTransferTransactionData should inherit from TransactionRequestData
                if (request.getStatus() != null) {
                    logger.info("Status:" + request.getStatus().getValue());
                    transactionStatusResponse.setStatus(request.getStatus());
                    transactionStatusResponse.setProcessingStatus(request.getProcessingStatus());
                }


                transactionStatusResponse.setLastUpdated(request.getLastUpdated().toString());
                return transactionStatusResponse;
            }

            logger.warn("no Transaction found");
            transactionStatusResponse.status(Statusenum.NOT_FOUND);

            return transactionStatusResponse;


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public CreditTransferRequest queryCTTransactionByTransactionId(String transactionId) {
        return null;
    }

    @Override
    public TransactionStatusResponse deleteTransaction(String transactionId, String type) {
        database = getDatabase();
        CollectionReference ref = database.collection(type);


        DocumentReference docRef1 = ref.document(transactionId);


        ApiFuture<DocumentSnapshot> querySnapshot1 = docRef1.get();


        TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
        transactionStatusResponse.setTransactionId(transactionId);

        try {

            DocumentSnapshot documentSnapshot1 = querySnapshot1.get();
            if (documentSnapshot1.exists()) {

                docRef1.update(TransactionJsonObjectMapper.LAST_UPDATED, Timestamp.now());
                WriteResult result = docRef1.update("status", Statusenum.DELETED).get();
                if (result.getUpdateTime() != null) {
                    logger.info("deleted transaction" + result.getUpdateTime());
                    transactionStatusResponse.setTransactionId(transactionId);
                    transactionStatusResponse.setLastUpdated(result.getUpdateTime().toString());
                    transactionStatusResponse.setStatus(Statusenum.DELETED);
                }
                return transactionStatusResponse;


            }


            throw new NoSuchElementException();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            logger.error("Transaction Not found");
            transactionStatusResponse.setStatus(Statusenum.NOT_FOUND);
            return transactionStatusResponse;
        }


    }


    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {
      /* CollectionReference ref =database.collection(TRANSACTION_COLLECTION);
        //Query query= ref.whereEqualTo(TransactionJsonObjectMapper.STATUS , Statusenum.CREATED);
        Query query= ref.whereLessThan(TransactionJsonObjectMapper.SCHEDULED_EXECUTION_DATE , Timestamp.now());
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<DirectDebitRequestData> directDebitRequestDataList= new ArrayList<>();
        try {
            for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
                // Access document data using document.toObject()
                System.out.println("Document ID: " + document.getId());
                DirectDebitRequestData directDebitRequestData=document.toObject(DirectDebitRequestData.class);
                if  (directDebitRequestData.getStatus()==Statusenum.CREATED)
                {
                    directDebitRequestDataList.add(directDebitRequestData);
                    directDebitRequestData.setStatus(Statusenum.PROCESSING);
                    WriteResult result=   document.getReference().set(directDebitRequestData).get();
                    logger.info("record fetched and updated " + result);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return  directDebitRequestDataList;*/

        List<QueryDocumentSnapshot> documentSnapshotList = fetchandUpdateReadyToProcessTransactions(DD_COLLECTION, Statusenum.CREATED, batchSize);
        List<DirectDebitRequestData> directDebitRequestDataList = new ArrayList<>();


        for (QueryDocumentSnapshot document : documentSnapshotList) {
            // Access document data using document.toObject()
            System.out.println("Document ID: " + document.getId());
            DirectDebitRequestData directDebitRequestData = document.toObject(DirectDebitRequestData.class);
            directDebitRequestDataList.add(directDebitRequestData);

        }


        return directDebitRequestDataList;

    }

    public List<QueryDocumentSnapshot> fetchandUpdateReadyToProcessTransactions(String collectionType, Statusenum status, int batchsize) {
        database = getDatabase();

        CollectionReference ref = database.collection(collectionType);
        //Query query= ref.whereEqualTo(TransactionJsonObjectMapper.STATUS , Statusenum.CREATED);

        Query query = ref.whereLessThan(TransactionJsonObjectMapper.SCHEDULED_EXECUTION_DATE, Timestamp.now()).whereEqualTo(TransactionJsonObjectMapper.STATUS, status).limit(batchsize);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<DirectDebitRequestData> directDebitRequestDataList = new ArrayList<>();
        try {
            List<QueryDocumentSnapshot> documentList = querySnapshot.get().getDocuments();
            for (QueryDocumentSnapshot document : documentList
            ) {
                document.getReference().update("status", Statusenum.PROCESSING).get();

            }
            return documentList;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


    public List<CreditTransferRequestData> getReadyToProcessCreditTransferransactions(int batchSize) {
        /*CollectionReference ref =database.collection();
        //Query query= ref.whereEqualTo(TransactionJsonObjectMapper.STATUS , Statusenum.CREATED);
        Query query= ref.whereLessThan(TransactionJsonObjectMapper.SCHEDULED_EXECUTION_DATE , Timestamp.now());
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<CreditTransferRequestData> creditTransferRequestDataList= new ArrayList<>();
        try {
            for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
                // Access document data using document.toObject()
                System.out.println("Document ID: " + document.getId());
                CreditTransferRequestData directDebitRequestData=document.toObject(CreditTransferRequestData.class);
                if  (directDebitRequestData.getStatus()==Statusenum.CREATED)
                {
                    creditTransferRequestDataList.add(directDebitRequestData);
                    directDebitRequestData.setStatus(Statusenum.PROCESSING);
                    WriteResult result=   document.getReference().set(directDebitRequestData).get();
                    logger.info("record fetched and updated " + result);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return  creditTransferRequestDataList;*/

        List<QueryDocumentSnapshot> documentSnapshotList = fetchandUpdateReadyToProcessTransactions(CT_COLLECTION, Statusenum.CREATED, batchSize);
        List<CreditTransferRequestData> creditTransferRequestDataList = new ArrayList<>();


        for (QueryDocumentSnapshot document : documentSnapshotList) {
            // Access document data using document.toObject()
            System.out.println("Document ID: " + document.getId());
            CreditTransferRequestData directDebitRequestData = document.toObject(CreditTransferRequestData.class);
            creditTransferRequestDataList.add(directDebitRequestData);

        }


        return creditTransferRequestDataList;
    }


}
