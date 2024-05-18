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

    private final AppWsConfig appWsConfig;

    public ClientConfig(AppWsConfig appWsConfig) {
        this.appWsConfig = appWsConfig;
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
                .baseUrl(appWsConfig.getUserServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */

        RestClient restClient = RestClient.builder().baseUrl(appWsConfig.getUserServiceUrl()).build();
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
                .baseUrl(appWsConfig.getMandateServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */
        RestClient restClient = RestClient.builder().baseUrl(appWsConfig.getMandateServiceUrl()).build();
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
                .baseUrl(appWsConfig.getSepaddServiceUrl())
                .build();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(webClientAdapter).build();
         */

        RestClient restClient = RestClient.builder().baseUrl(appWsConfig.getSepaddServiceUrl()).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(SepaddClient.class);
    }
}
