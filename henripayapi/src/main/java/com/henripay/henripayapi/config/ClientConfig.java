package com.henripay.henripayapi.config;

import com.henripay.henripayapi.client.MandateClient;
import com.henripay.henripayapi.client.SepaddClient;
import com.henripay.henripayapi.client.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    private final AppUrlsConfig appUrlsConfig;

    public ClientConfig(AppUrlsConfig appUrlsConfig) {
        this.appUrlsConfig = appUrlsConfig;
    }

    @Bean
    UserClient userClient() {
        /*
        WebClient client = WebClient
                .builder()
//                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp ->
//                        resp.bodyToMono(String.class)
//                                .flatMap(errorBody -> Mono.error(new Exception400(errorBody)))
//                )
//                .defaultStatusHandler(HttpStatusCode::is5xxServerError, resp ->
//                        Mono.just(new RuntimeException(resp.statusCode().toString()))
//                )
                .baseUrl(appUrlsConfig.getUserServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */

        RestClient restClient = RestClient.builder().baseUrl(appUrlsConfig.getUserServiceUrl()).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(UserClient.class);
    }

    @Bean
    MandateClient mandateClient() {
        /*
        WebClient client = WebClient
                .builder()
//                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp ->
//                        resp.bodyToMono(String.class)
//                                .flatMap(errorBody -> Mono.error(new Exception400(errorBody)))
//                )
//                .defaultStatusHandler(HttpStatusCode::is5xxServerError, resp ->
//                        Mono.just(new RuntimeException(resp.statusCode().toString()))
//                )
                .baseUrl(appUrlsConfig.getMandateServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */
        RestClient restClient = RestClient.builder().baseUrl(appUrlsConfig.getMandateServiceUrl()).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(MandateClient.class);
    }

    @Bean
    SepaddClient sepaddClient() {
        /*
        WebClient client = WebClient
                .builder()
//                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp ->
//                        resp.bodyToMono(String.class)
//                                .flatMap(errorBody -> Mono.error(new Exception400(errorBody)))
//                )
//                .defaultStatusHandler(HttpStatusCode::is5xxServerError, resp ->
//                        Mono.just(new RuntimeException(resp.statusCode().toString()))
//                )
                .baseUrl(appUrlsConfig.getSepaddServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */

        RestClient restClient = RestClient.builder().baseUrl(appUrlsConfig.getSepaddServiceUrl()).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(SepaddClient.class);
    }
}