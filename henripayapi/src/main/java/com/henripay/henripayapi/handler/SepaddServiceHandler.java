package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.SepaddClient;
import com.henripay.henripayapi.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.henripay.henripayapi.dto.mapper.DirectDebitRequestMapper.mapToDirectDebitRequest;
import static com.henripay.henripayapi.web.utils.HandlerUtils.throwBpmnError;

@Component
@Slf4j
public class SepaddServiceHandler {

    private final SepaddClient sepaddClient;

    public SepaddServiceHandler(SepaddClient sepaddClient) {
        this.sepaddClient = sepaddClient;
    }

    @Bean
    public JavaDelegate addDirectDebitTransaction() {
        return execution -> {
            log.info("Running addDirectDebitTransaction");
            try {
                var collectionInformation = (Collectioninformation) execution.getVariable("collectionInformation");
                var mandateDetails = (MandateDTO) execution.getVariable("mandateDetails");
                var userDetails = (UserDTO) execution.getVariable("userDetails");
                //
                DirectDebitRequest directDebitRequest = new DirectDebitRequest();
                mapToDirectDebitRequest(directDebitRequest, collectionInformation, mandateDetails, userDetails);
                //
                TransactionResponse transactionResponse = this.sepaddClient.addDirectDebitTransaction(directDebitRequest);
                if (transactionResponse == null) {
                    throwBpmnError(execution, "Error adding direct debit transaction");
                } else {
                    execution.setVariable("transactionResponse", transactionResponse);
                }
            } catch (Exception e) {
                throwBpmnError(execution, "Error adding direct debit transaction");
            }
        };
    }

    @Bean
    public JavaDelegate addCreditTransferTransaction() {
        return execution -> {
            log.info("Running addCreditTransferTransaction");
//            try {
//                var creditTransferRequest = (CreditTransferRequest) execution.getVariable("creditTransferRequest");
//                var response = this.sepaddClient.addCreditTransaction(creditTransferRequest);
//                response.subscribe(addCreditTransactionResponse -> {
//                    execution.setVariable("addCreditTransactionResponse",addCreditTransactionResponse);
//                });
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }

        };
    }

    @Bean
    public JavaDelegate cancelAddDirectDebitTransaction() {
        return execution -> {
            // TODO: refactor delete transaction
//            String directDebitRequest = (String) execution.getVariable("transactionId");
//            Mono<TransactionResponse> response = this.sepaddClient.deleteTransaction(directDebitRequest);
//            response.subscribe(deleteTransactionResponseDto -> {
//                execution.setVariable("deleteTransactionResponse", deleteTransactionResponseDto);
//            });
            log.error("addDirectDebitTransaction failed");
        };
    }
}
