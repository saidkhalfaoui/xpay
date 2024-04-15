package com.henripay.sepadd.service.impl;

import com.henripay.sepadd.dto.DirectDebitRequestData;
import com.henripay.sepadd.dto.GenerateBatchFileResponse;
import com.henripay.sepadd.helper.CsvFileHelper;
import com.henripay.sepadd.service.BatchFileService;
import com.henripay.sepadd.service.configuration.BatchFilesConfigurations;
import com.henripay.sepadd.service.configuration.CsvProperties;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
public class DirectDebitBatchFileGen implements BatchFileService {
    private final TransactionServiceImpl transactionService;
    private final BatchFilesConfigurations batchFilesConfiguration;

    private final CsvProperties csvProperties;

    public DirectDebitBatchFileGen(TransactionServiceImpl transactionService, BatchFilesConfigurations batchFilesConfiguration, CsvProperties csvProperties) {
        this.transactionService = transactionService;
        this.batchFilesConfiguration = batchFilesConfiguration;
        this.csvProperties = csvProperties;
    }

    @Override
    public GenerateBatchFileResponse generateBatchFile() {
        GenerateBatchFileResponse response = new GenerateBatchFileResponse();
        List<DirectDebitRequestData> directDebitRequestDataList = this.transactionService
                .getReadyToProcessDirectDebitTransactions(
                        this.batchFilesConfiguration.getBatchSize()
                );
        // No Data to process
        if (directDebitRequestDataList == null || directDebitRequestDataList.isEmpty()) {
            response.setFileGenerated(false);
            response.setFilePath("");
            return response;
        }
        String separator = this.csvProperties.getCsvSeparator();
        List<String> csvData = new ArrayList<>();
        csvData.add("customer id"+separator+"customer name"+separator+"amount"+separator+"BIC"+separator+"iban"+separator+"currency"+separator+"transaction information"+separator+"additional info"+separator+"mandatereference"+separator+"mandate date");

        csvData.addAll(directDebitRequestDataList.stream()
                .map(data ->
                        // amount;
                        data.getAmount() + separator
                        // BIC;
                        + "" + separator // TODO:
                        // iban;
                        + data.getAccountInfo().getIBAN() + separator
                        // currency
                        + data.getCurrency() + separator
                        // transaction information;
                        + data.getTransactionType() + separator
                        // additional info;
                        + "" + separator // TODO:
                        // mandatereference;
                        + data.getMandateInformation().getMandateId() + separator
                        // mandate date
                        + data.getMandateInformation().getDateOfsignature()
                )
                .toList()
        );

        try {
            Path csvPath = CsvFileHelper.writeCsvFile(csvData, "008.001");
            response.setFileGenerated(true);
            response.setFilePath(csvPath.getFileSystem().toString());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        return response;
    }
}