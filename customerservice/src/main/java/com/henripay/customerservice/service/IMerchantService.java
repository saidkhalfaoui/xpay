package com.henripay.customerservice.service;

//import com.henripay.domainservice.entity.MerchantEntity;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.domainservice.entity.MerchantEntity;

import java.util.List;


public interface IMerchantService {
    MerchantDTO saveMerchant(MerchantDTO merchant);
    MerchantDTO getMerchantById(Long id);
    List<MerchantDTO> getAllMerchants();
    void deleteMerchant(Long id);
    MerchantDTO updateMerchantById(Long id, MerchantDTO merchantDTO);
}