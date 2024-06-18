package com.xpay.customerservice.delegate;

import com.xpay.customerservice.controller.MerchantApiDelegate;
import com.xpay.customerservice.dto.MerchantDTO;
import com.xpay.customerservice.service.impl.MerchantService;
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
    public ResponseEntity<MerchantDTO> merchantFindByIbanGet(String iban) {
        return ResponseEntity.ok(merchantService.findByIban(iban));
    }

    @Override
    public ResponseEntity<MerchantDTO> updateMerchantById(Long id, MerchantDTO merchantDTO) {
        return ResponseEntity.ok(merchantService.updateMerchantById(id, merchantDTO));
    }
}
