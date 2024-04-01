package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.UserDetailsDto;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;


public interface UserClient {

    @GetExchange("/users/{id}")
    Mono<UserDetailsDto> getUserDetails(@PathVariable("id") Integer userId);
}
