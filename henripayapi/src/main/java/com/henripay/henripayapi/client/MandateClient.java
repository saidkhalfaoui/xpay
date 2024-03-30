package com.henripay.henripayapi.client;

import com.henripay.henripayapi.apiClient.ApiClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.Map;

@Service
public class MandateClient {
    private final ApiClient apiClient;
    private final String mandateServiceUrl;


    public MandateClient(ApiClient apiClient, AppUrlsConfig appUrlsConfig) {
        this.apiClient = apiClient;
        this.mandateServiceUrl = appUrlsConfig.getMandateServiceUrl();
    }

    public Map<String, Object> getMandateDetails(Integer mandateId) throws IOException, RestClientException {
        String getMandateDetailsUrl = this.mandateServiceUrl + "/mandates/" + mandateId;
        return this.apiClient.makeCall(HttpMethod.GET, getMandateDetailsUrl, null, Map.class);

    }
}
