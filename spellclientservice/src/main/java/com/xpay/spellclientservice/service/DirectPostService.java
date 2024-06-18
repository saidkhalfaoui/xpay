package com.xpay.spellclientservice.service;

import com.xpay.spellclientservice.api.model.DirectPostRequestDto;

import java.io.IOException;

public interface DirectPostService {
    Object doDirectPost(String directPostUrl, DirectPostRequestDto directPostRequestDto) throws IOException;
}
