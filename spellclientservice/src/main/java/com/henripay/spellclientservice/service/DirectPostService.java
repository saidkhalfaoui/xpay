package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;

public interface DirectPostService {
    Object doDirectPost(DirectPostRequestDto directPostRequestDto);
}
