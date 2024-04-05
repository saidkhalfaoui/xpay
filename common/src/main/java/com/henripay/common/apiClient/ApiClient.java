package com.henripay.common.apiClient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


public class ApiClient {

    public static  <R> R getApiService(String baseUrl, Class<R> serviceType) {
        WebClient webClient =  WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(webClientAdapter)
                .build();
        return factory.createClient(serviceType);
    }

}
