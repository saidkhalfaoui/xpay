package com.henripay.spellclientservice.apiClient;

import org.springframework.http.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface ApiClient {
     <T> Object makeCall(HttpMethod httpMethod, String url, T params, String apiKey) throws IOException;
}
