package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.MandateDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface MandateClient {

    @GetExchange("/mandates/{id}")
    MandateDTO getMandateDetails(@PathVariable("id") Long id);
}
