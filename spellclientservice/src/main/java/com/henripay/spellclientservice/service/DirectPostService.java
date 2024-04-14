package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.dto.DirectPostRequestDto;

import java.io.IOException;

public interface DirectPostService {
    Object doDirectPost(String directPostUrl, DirectPostRequestDto directPostRequestDto) throws IOException;
}
