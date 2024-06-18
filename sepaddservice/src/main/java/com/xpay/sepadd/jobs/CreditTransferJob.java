package com.xpay.sepadd.jobs;

import com.xpay.sepadd.dto.CreditTransferRequestData;
import com.xpay.sepadd.dto.CreditorInfo;
import com.xpay.sepadd.iso20022.sepa.CreditTransferPainFile;
import com.xpay.sepadd.service.TransactionService;
import com.xpay.sepadd.service.configuration.ConfigurationService;
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
public class CreditTransferJob extends BaseJob implements Runnable {

    Logger logger = LoggerFactory.getLogger(DirectDebitJob.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ConfigurationService configurationService;

    @Override
    public void run() {

        CreditorInfo debitorInfo = configurationService.getDefaultCreditorInfo();  /*rename CreditorInfo*/
        CreditTransferPainFile creditTransferPainFile = new CreditTransferPainFile(configurationService);
        creditTransferPainFile.buildGroupHeader(null, "test", Date.from(Instant.now()));

        while (!isCancelled) {
            if (!isPaused) {
                // Execute job steps

                List<CreditTransferRequestData> requestDataList = transactionService.getReadyToProcessCreditTransferTransactions(50/*jobProperties.getBatchSize() to be fixed*/);
                if (requestDataList.isEmpty()) {
                    logger.info("No More transaction found , Jobs completed ");
                    isCompleted = true;
                    break;
                }
                for (CreditTransferRequestData requestData : requestDataList) {
                    try {
                        creditTransferPainFile.paymentGroup(debitorInfo, requestData).addTransaction(requestData);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                }


            } else {
                // Job is paused, wait or perform appropriate actions
            }

        }
        try {
            creditTransferPainFile.write("C:\\Users\\User\\");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        logger.info("Job Completed Successfully");
    }

}
