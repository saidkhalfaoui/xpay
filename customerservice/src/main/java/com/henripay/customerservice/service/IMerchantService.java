package com.henripay.customerservice.service;


import com.henripay.customerservice.dto.MerchantDTO;

import java.util.List;
import java.util.Optional;


public interface IMerchantService {
    MerchantDTO saveMerchant(MerchantDTO merchant);
    MerchantDTO getMerchantById(Long id);
    List<MerchantDTO> getAllMerchants();
    void deleteMerchant(Long id);
    MerchantDTO updateMerchantById(Long id, MerchantDTO merchantDTO);
    MerchantDTO findByIban(String iban);
}