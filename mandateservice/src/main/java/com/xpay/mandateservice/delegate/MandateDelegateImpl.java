package com.xpay.mandateservice.delegate;

import com.xpay.mandateservice.controller.MandatesApiDelegate;
import com.xpay.mandateservice.dto.MandateDTO;
import com.xpay.mandateservice.service.Impl.MandateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MandateDelegateImpl implements MandatesApiDelegate {
    private final MandateService mandateService;

    public MandateDelegateImpl(MandateService mandateService) {
        this.mandateService = mandateService;
    }

    @Override
    public ResponseEntity<Void> deleteMandate(Long mandateIdentifier) {
        mandateService.deleteMandate(mandateIdentifier);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<MandateDTO>> getAllMandates() {
        return ResponseEntity.ok(mandateService.getAllMandates());
    }

    @Override
    public ResponseEntity<MandateDTO> getMandateById(Long mandateIdentifier) {
        return ResponseEntity.ok(mandateService.getMandateById(mandateIdentifier));
    }

    @Override
    public ResponseEntity<MandateDTO> saveMandate(MandateDTO mandateDTO) {
        return ResponseEntity.ok(mandateService.saveMandate(mandateDTO));
    }

    @Override
    public ResponseEntity<MandateDTO> updateMandateById(Long mandateIdentifier, MandateDTO mandateDTO) {
        return ResponseEntity.ok(mandateService.updateMandateById(mandateIdentifier,mandateDTO));
    }
}
