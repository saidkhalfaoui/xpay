package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.MandateDetailsDto;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

public interface MandateClient {

    @GetExchange("/mandates/{id}")
    Mono<MandateDetailsDto> getMandateDetails(@PathVariable("id") Integer id);
}
