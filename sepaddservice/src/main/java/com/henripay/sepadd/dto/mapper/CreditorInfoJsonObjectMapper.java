package com.henripay.sepadd.dto.mapper;

import com.henripay.sepadd.dto.Accountinformation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditorInfoJsonObjectMapper {

    private Accountinformation accountinformation;
    private String isDefault;
    // add additional info

}
