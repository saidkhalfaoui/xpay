package com.henripay.mandateservice.service.Impl;

import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.domainservice.repository.MandateRepository;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.mandateservice.mapper.MandateMapper;
import com.henripay.mandateservice.service.IMandateService;

import java.util.List;

public class MandateService implements IMandateService {
    private final MandateRepository merchantRepository;
    private final MandateMapper mandateMapper;

    public MandateService(MandateRepository merchantRepository, MandateMapper mapper){
        this.mandateMapper = mapper;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public MandateEntity saveMandate(MandateEntity mandate) {
        return null;
    }

    @Override
    public MandateEntity getMandateById(Long id) {
        return null;
    }

    @Override
    public List<MandateEntity> getAllMandates() {
        return null;
    }

    @Override
    public void deleteMandate(Long id) {

    }

    @Override
    public MandateEntity updateMandateById(Long id, MandateEntity MandateEntity) {
        return null;
    }

    @Override
    public MandateEntity findByIban(String iban) {
        return null;
    }
}
