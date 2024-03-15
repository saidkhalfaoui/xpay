package com.henripay.customerservice.delegate;

import com.henripay.customerservice.controller.MerchantApiDelegate;
import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.customerservice.service.impl.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantDelegateImpl implements MerchantApiDelegate {
    private final MerchantService merchantService;
    public MerchantDelegateImpl(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public ResponseEntity<MerchantDTO> saveMerchant(MerchantDTO merchantDTO) {
        System. out. println( "merchantDTO.toString()");
        System. out. println( merchantDTO.toString());
        return ResponseEntity.ok(merchantService.saveMerchant(merchantDTO));
    }
    @Override
    public ResponseEntity<List<MerchantDTO>> getMerchants() {
        return ResponseEntity.ok(merchantService.getAllMerchants());
    }

    @Override
    public ResponseEntity<Void> deleteMerchantById(Long id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<MerchantDTO> getMerchantById(Long id) {
        return ResponseEntity.ok(merchantService.getMerchantById(id));
    }

    @Override
    public ResponseEntity<MerchantDTO> updateMerchantById(Long id, MerchantDTO merchantDTO) {
        return ResponseEntity.ok(merchantService.updateMerchantById(id, merchantDTO));
    }
}
