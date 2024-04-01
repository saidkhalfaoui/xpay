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
public class AddDirectDebitTransactionHandler {

    private final SepaddClient sepaddClient;


    public AddDirectDebitTransactionHandler(AppUrlsConfig appUrlsConfig) {
        this.sepaddClient = ApiClient.getApiService(appUrlsConfig.getSepaddServiceUrl(), SepaddClient.class);
    }

    @Bean
    public JavaDelegate addDirectDebitTransaction() {
        return execution -> {
            log.info("Running addDirectDebitTransaction");
            try {
                DirectDebitRequest directDebitRequest = (DirectDebitRequest) execution.getVariable("directDebitRequest");
                Mono<TransactionResponse> response = this.sepaddClient.addDirectDebitTransaction(directDebitRequest);
                response.subscribe(transactionResponse -> {
                    execution.setVariable("transactionResponse", transactionResponse);
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }


    @Bean
    public JavaDelegate cancelAddDirectDebitTransaction(){
        return execution -> {
            log.error("addDirectDebitTransaction failed");
        };
    }
}
