package com.xpay.customerservice.service;


import com.xpay.customerservice.dto.MerchantDTO;

import java.util.List;


public interface IMerchantService {
    MerchantDTO saveMerchant(MerchantDTO merchant);
    MerchantDTO getMerchantById(Long id);
    List<MerchantDTO> getAllMerchants();
    void deleteMerchant(Long id);
    MerchantDTO updateMerchantById(Long id, MerchantDTO merchantDTO);
    MerchantDTO findByIban(String iban);
}
