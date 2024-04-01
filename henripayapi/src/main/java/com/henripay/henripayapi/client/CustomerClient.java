package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.UserDTO;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

public interface CustomerClient {

    UserDTO getCustomerDetails(String customerId) throws IOException, RestClientException;
}
