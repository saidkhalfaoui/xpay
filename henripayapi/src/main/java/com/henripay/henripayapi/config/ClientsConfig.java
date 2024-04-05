package com.henripay.henripayapi.config;

import com.henripay.common.apiClient.ApiClient;
import com.henripay.henripayapi.client.MandateClient;
import com.henripay.henripayapi.client.SepaddClient;
import com.henripay.henripayapi.client.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {

    @Bean
    public UserClient userClient(AppUrlsConfig appUrlsConfig) {
        return ApiClient.getApiService(appUrlsConfig.getUserServiceUrl(), UserClient.class);
    }

    @Bean
    public SepaddClient sepaddClient(AppUrlsConfig appUrlsConfig) {
        return ApiClient.getApiService(appUrlsConfig.getSepaddServiceUrl(), SepaddClient.class);
    }

    @Bean
    public MandateClient mandateClient(AppUrlsConfig appUrlsConfig) {
        return ApiClient.getApiService(appUrlsConfig.getMandateServiceUrl(), MandateClient.class);
    }
}
