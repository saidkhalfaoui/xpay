package com.xpay.xpayapi.client;

import com.xpay.xpayapi.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;


public interface UserClient {

    @GetExchange("/users/{id}")
    UserDTO getUserDetails(@PathVariable("id") Long userId);
}
