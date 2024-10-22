package com.xpay.customerservice.service.impl;

import com.xpay.common.exception.InvalidInput;
import com.xpay.customerservice.dto.MerchantDTO;
import com.xpay.customerservice.mapper.MerchantMapper;
import com.xpay.customerservice.service.IMerchantService;
import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantService implements IMerchantService {
    private final MerchantRepository merchantRepository;
    private final MerchantMapper mapper;

    public MerchantService(MerchantRepository merchantRepository, MerchantMapper mapper){
        this.mapper = mapper;
        this.merchantRepository = merchantRepository;
    }
    @Override
    public MerchantDTO saveMerchant(MerchantDTO merchantDTO) {
        MerchantEntity merchant = mapper.toEntity(merchantDTO);
        MerchantEntity savedMerchant =  merchantRepository.save(merchant);
        return  mapper.toDto(savedMerchant);
    }

    @Override
    public MerchantDTO getMerchantById(Long id) {
        Optional<MerchantEntity> merchant = merchantRepository.findById(id);
        return  mapper.toDto(merchant.orElseThrow(() -> new InvalidInput("Merchant not found")));
    }

    @Override
    public List<MerchantDTO> getAllMerchants() {
        return mapper.toDtoList (merchantRepository.findAll());
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.findById(id).orElseThrow(() -> new InvalidInput("Merchant not found"));
        merchantRepository.deleteById(id);
    }

    @Override
    public MerchantDTO updateMerchantById(Long id, MerchantDTO merchantDTO) {
        MerchantEntity merchant = merchantRepository.findById(id).orElseThrow(() -> new InvalidInput("Merchant not found"));
        mapper.updateFromDto(merchantDTO, merchant);
        return mapper.toDto(merchantRepository.save(merchant));
    }

    @Override
    public MerchantDTO findByIban(String iban) {
        Optional<MerchantEntity> merchant = merchantRepository.findByMerchantIban(iban);
        return  mapper.toDto(merchant.orElseThrow(() -> new InvalidInput("Merchant not found")));
    }
}
