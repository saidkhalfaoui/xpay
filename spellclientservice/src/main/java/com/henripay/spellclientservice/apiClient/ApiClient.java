package com.henripay.spellclientservice.apiClient;

public interface ApiClient<T, R> {
    R makeCall(T params);
}
