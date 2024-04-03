package com.henripay.henripayapi.handler;

import com.henripay.common.apiClient.ApiClient;
import com.henripay.henripayapi.client.SepaddClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import com.henripay.henripayapi.dto.DirectDebitRequest;
import com.henripay.henripayapi.dto.TransactionResponse;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class SepaddServiceHandler {

    private final SepaddClient sepaddClient;


    public SepaddServiceHandler(AppUrlsConfig appUrlsConfig) {
        this.sepaddClient = ApiClient.getApiService(appUrlsConfig.getSepaddServiceUrl(), SepaddClient.class);
    }

    @Bean
    public JavaDelegate addDirectDebitTransaction() {
        return execution -> {
            log.info("Running addDirectDebitTransaction");
            try {
                DirectDebitRequest directDebitRequest = (DirectDebitRequest) execution.getVariable("directDebitRequest");
                Mono<TransactionResponse> response = this.sepaddClient.addDirectDebitTransaction(directDebitRequest);
                response.subscribe(addDirectDebitTransactionResponse -> {
                    execution.setVariable("addDirectDebitTransactionResponse", addDirectDebitTransactionResponse);
                });
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
            String directDebitRequest = (String) execution.getVariable("transactionId");
            Mono<TransactionResponse> response = this.sepaddClient.deleteTransaction(directDebitRequest);
            response.subscribe(deleteTransactionResponseDto -> {
                execution.setVariable("deleteTransactionResponse", deleteTransactionResponseDto);
            });
            log.error("addDirectDebitTransaction failed");
        };
    }
}
