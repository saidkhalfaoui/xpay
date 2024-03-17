package com.henripay.mandateservice.service;

import com.henripay.domainservice.entity.MandateEntity;

import java.util.List;

public interface IMandateService {

    MandateEntity saveMandate(MandateEntity mandate);
    MandateEntity getMandateById(Long id);
    List<MandateEntity> getAllMandates();
    void deleteMandate(Long id);
    MandateEntity updateMandateById(Long id, MandateEntity MandateEntity);
    MandateEntity findByIban(String iban);
}
