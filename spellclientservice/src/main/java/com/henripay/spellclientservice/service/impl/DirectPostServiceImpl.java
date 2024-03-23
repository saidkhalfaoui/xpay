package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.api.model.DirectPostResponseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.service.DirectPostService;
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
