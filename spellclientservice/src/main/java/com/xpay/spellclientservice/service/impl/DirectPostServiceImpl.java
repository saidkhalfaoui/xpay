package com.xpay.spellclientservice.service.impl;

import com.xpay.spellclientservice.api.model.DirectPostRequestDto;
import com.xpay.spellclientservice.api.model.DirectPostResponseDto;
import com.xpay.spellclientservice.apiClient.ApiClient;
import com.xpay.spellclientservice.config.SpellConfig;
import com.xpay.spellclientservice.service.DirectPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DirectPostServiceImpl implements DirectPostService {

    private final ApiClient apiClient;
    private final SpellConfig spellConfig;

    @Autowired
    public DirectPostServiceImpl(ApiClient apiClient, SpellConfig spellConfig) {
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
    }

    @Override
    public DirectPostResponseDto doDirectPost(String directPostUrl, DirectPostRequestDto directPostRequestDto) throws IOException {

        return this.apiClient.makeCall(
                HttpMethod.POST,
                directPostUrl+"?s2s=true",
                directPostRequestDto,
                this.spellConfig.getHenriApiKey(),
                DirectPostResponseDto.class
        );
    }
}
