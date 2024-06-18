package com.xpay.mandateservice.service;

import com.xpay.mandateservice.dto.MandateDTO;

import java.util.List;

public interface IMandateService {

    MandateDTO saveMandate(MandateDTO mandateDto);
    MandateDTO getMandateById(Long id);
    List<MandateDTO> getAllMandates();
    void deleteMandate(Long id);
    MandateDTO updateMandateById(Long id, MandateDTO mandateDTO);}
