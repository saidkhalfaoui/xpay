package com.henripay.sepadd.jobs;


import com.henripay.sepadd.api.model.CreditorInfo;
import com.henripay.sepadd.api.model.DirectDebitRequestData;

import com.henripay.sepadd.iso20022.sepa.sdd.DirectDebitPainFile;
import com.henripay.sepadd.service.TransactionService;

import com.henripay.sepadd.service.configuration.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
public class DirectDebitJob extends BaseJob implements Runnable {

    Logger logger = LoggerFactory.getLogger(DirectDebitJob.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ConfigurationService configurationService;


    public DirectDebitJob() {

    }


    @Override
    public void run() {

        CreditorInfo creditorInfo = configurationService.getDefaultCreditorInfo();
        DirectDebitPainFile directDebitPainFile = new DirectDebitPainFile(configurationService);
        directDebitPainFile.buildGroupHeader(null, "test", Date.from(Instant.now()));

        while (!isCancelled) {
            if (!isPaused) {
                // Execute job steps

                List<DirectDebitRequestData> requestDataList = transactionService.getReadyToProcessDirectDebitTransactions(50/*jobProperties.getBatchSize() to be fixed*/);
                if (requestDataList.isEmpty()) {
                    logger.info("No More transaction found , Jobs completed ");
                    isCompleted = true;
                    break;
                }
                for (DirectDebitRequestData requestData : requestDataList) {
                    try {
                        directDebitPainFile.paymentInstruction(creditorInfo, requestData).addTransaction(requestData);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                }


            } else {
                // Job is paused, wait or perform appropriate actions
            }

        }
        try {
            directDebitPainFile.write("C:\\Users\\User\\");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        logger.info("Job Completed Successfully");
    }


}

