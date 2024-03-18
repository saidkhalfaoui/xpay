package com.henripay.customerservice.service.impl;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.customerservice.mapper.MerchantMapper;
import com.henripay.customerservice.service.IMerchantService;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
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
        return  mapper.toDto(merchant.orElseThrow(() -> new NotFoundException("Merchant not found")));
    }

    @Override
    public List<MerchantDTO> getAllMerchants() {
        return mapper.toDtoList (merchantRepository.findAll());
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public MerchantDTO updateMerchantById(Long id, MerchantDTO merchantDTO) {
        MerchantEntity merchant = merchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Merchant not found"));
        mapper.updateFromDto(merchantDTO, merchant);
        merchantRepository.save(merchant);
        return mapper.toDto(merchant);
    }


//    public MerchantDTO saveMerchant(MerchantDTO merchantDTO) {
//        MerchantDTO merchant = new MerchantDTO();
//
//        // Set values for the merchant properties
//        merchant.setMerchantId("123456789"); // Set a sample merchant ID
//        merchant.setMerchantName("Example Merchant");
//        merchant.setMerchantAddress("123 Main Street, City");
//        merchant.setMerchantIban("GB29XABC12345612345678"); // Set a sample IBAN
//        merchant.setMerchantCode("M123");
//        merchant.setMerchantMeta(42); // Set a sample meta value
//        merchant.setIdMerchantAggregator(9876); // Set a sample aggregator ID
//
//        // Return the created merchant
//        return merchant;
//    }
//    public MerchantDTO getMerchant() {
//        MerchantDTO merchant = new MerchantDTO();
//
//        // Set values for the merchant properties
//        merchant.setMerchantId("123456789"); // Set a sample merchant ID
//        merchant.setMerchantName("Example Merchant");
//        merchant.setMerchantAddress("123 Main Street, City");
//        merchant.setMerchantIban("GB29XABC12345612345678"); // Set a sample IBAN
//        merchant.setMerchantCode("M123");
//        merchant.setMerchantMeta(42); // Set a sample meta value
//        merchant.setIdMerchantAggregator(9876); // Set a sample aggregator ID
//
//        // Return the created merchant
//        return merchant;
//    }

}
