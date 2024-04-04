package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.UserDTO;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;


public interface UserClient {

    @GetExchange("/users/{id}")
    Mono<UserDTO> getUserDetails(@PathVariable("id") Long userId);
}
