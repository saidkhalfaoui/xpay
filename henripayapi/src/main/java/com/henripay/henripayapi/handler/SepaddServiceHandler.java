package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.SepaddClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
//                DirectDebitRequest directDebitRequest = (DirectDebitRequest) execution.getVariable("directDebitRequest");
//                Mono<TransactionResponse> response = this.sepaddClient.addDirectDebitTransaction(directDebitRequest);
//                response.subscribe(addDirectDebitTransactionResponse -> {
//                    execution.setVariable("addDirectDebitTransactionResponse", addDirectDebitTransactionResponse);
//                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public JavaDelegate addCreditTransferTransaction(){
        return execution -> {
            log.info("Running addCreditTransferTransaction");
            try {
//                var creditTransferRequest = (CreditTransferRequest) execution.getVariable("creditTransferRequest");
//                var response = this.sepaddClient.addCreditTransaction(creditTransferRequest);
//                response.subscribe(addCreditTransactionResponse -> {
//                    execution.setVariable("addCreditTransactionResponse",addCreditTransactionResponse);
//                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        };
    }

    @Bean
    public JavaDelegate cancelAddDirectDebitTransaction(){
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
