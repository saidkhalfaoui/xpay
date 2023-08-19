package com.skwar.emvissuance.awsclient;




import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonClient {

    private final ObjectMapper objectMapper;

    public JsonClient() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> T get(String url, Class<T> clazz) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);

        return objectMapper.readValue(reader, clazz);
    }
    public <T> T post(String url, Class<T> clazz) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        String authHeader="basic authenticaion header";
        connection.setRequestProperty("Authorization",authHeader);

        String json = objectMapper.writeValueAsString(clazz.toString());
        connection.setDoOutput(true);
        connection.getOutputStream().write(json.getBytes());

        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);

        return objectMapper.readValue(reader, clazz);
    }

    public <T> T put(String url, Class <T> clazz) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");

        String json = objectMapper.writeValueAsString(clazz);
        connection.setDoOutput(true);
        connection.getOutputStream().write(json.getBytes());

        InputStream inputStream = connection.getInputStream();
        Reader reader = new InputStreamReader(inputStream);


        return objectMapper.readValue(reader, clazz);
    }
}
