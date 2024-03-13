package com.henripay.customerservice.delegate;

import com.henripay.customerservice.controller.MerchantApiDelegate;
import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.customerservice.service.impl.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantDelegateImpl implements MerchantApiDelegate {
    private final MerchantService merchantService;
    public MerchantDelegateImpl(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public ResponseEntity<MerchantDTO> saveMerchant(MerchantDTO merchantDTO) {
        return ResponseEntity.ok(merchantService.saveMerchant(merchantDTO));
    }

    @Override
    public ResponseEntity<MerchantDTO> getMerchant() {
        return ResponseEntity.ok(merchantService.getMerchant());
    }

    @Override
    public ResponseEntity<Void> deleteMerchantById(Integer id) {
        return MerchantApiDelegate.super.deleteMerchantById(id);
    }

    @Override
    public ResponseEntity<MerchantDTO> getMerchantById(Integer id) {
        return MerchantApiDelegate.super.getMerchantById(id);
    }

    @Override
    public ResponseEntity<MerchantDTO> updateMerchantById(Integer id, MerchantDTO merchantDTO) {
        return MerchantApiDelegate.super.updateMerchantById(id, merchantDTO);
    }
}
