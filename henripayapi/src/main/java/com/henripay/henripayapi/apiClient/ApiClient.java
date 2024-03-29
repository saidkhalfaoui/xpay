package com.henripay.henripayapi.apiClient;

import org.springframework.http.HttpMethod;

import java.io.IOException;

public interface ApiClient {
    <T, R> R makeCall(HttpMethod httpMethod, String url, T params, Class<R> responseType) throws IOException;
}
