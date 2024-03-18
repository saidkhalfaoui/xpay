package com.henripay.mandateservice.delegate;

import com.henripay.mandateservice.controller.MandatesApiDelegate;
import com.henripay.mandateservice.dto.MandateDTO;
import com.henripay.mandateservice.service.Impl.MandateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Service
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
