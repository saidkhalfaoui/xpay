package com.henripay.spellclientservice.apiClient;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface ApiClient {
    <T, R> R makeCall(HttpMethod httpMethod, String url, T params, String apiKey, Class<R> responseType) throws IOException;
}
