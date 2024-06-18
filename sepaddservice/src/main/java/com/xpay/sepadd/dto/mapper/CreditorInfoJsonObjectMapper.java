package com.xpay.sepadd.dto.mapper;

import com.xpay.sepadd.dto.Accountinformation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditorInfoJsonObjectMapper {

    private Accountinformation accountinformation;
    private String isDefault;
    // add additional info

}
