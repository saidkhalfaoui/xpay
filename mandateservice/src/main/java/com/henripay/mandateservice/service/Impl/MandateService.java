package com.henripay.mandateservice.service.Impl;

import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.exception.InvalidInput;
import com.henripay.domainservice.repository.MandateRepository;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.domainservice.repository.UserRepository;
import com.henripay.mandateservice.dto.MandateDTO;
import com.henripay.mandateservice.mapper.MandateMapper;
import com.henripay.mandateservice.service.IMandateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MandateService implements IMandateService {
    private final MandateRepository mandateRepository;
    private final UserRepository userRepository;
    private final MerchantRepository merchantRepository;
    private final MandateMapper mandateMapper;

    public MandateService(MandateRepository mandateRepository, MerchantRepository merchantRepository, UserRepository userRepository,  MandateMapper mapper){
        this.mandateMapper = mapper;
        this.mandateRepository = mandateRepository;
        this.merchantRepository = merchantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MandateDTO saveMandate(MandateDTO mandateDTO) {

        if(!merchantRepository.existsById(mandateDTO.getMerchant())){
            throw new InvalidInput("Invalid Merchant");
        }
        if (!userRepository.existsById(mandateDTO.getCustomer())){
            throw new InvalidInput("Invalid Customer");
        }
        UserEntity customer = UserEntity.builder().customerIdIdentifier(mandateDTO.getCustomer()).build();
        MerchantEntity merchant = MerchantEntity.builder().merchantId(mandateDTO.getMerchant()).build();
        if (isMandateExists(customer, merchant)){
            return mandateMapper.toDto(mandateRepository.findByCustomerAndMerchant(customer, merchant));
        }

        MandateEntity mandate = mandateMapper.toEntity(mandateDTO);
        MandateEntity saveMandate =  mandateRepository.save(mandate);
        return  mandateMapper.toDto(saveMandate);
    }

    @Override
    public MandateDTO getMandateById(Long id) {
        return mandateMapper.toDto(
                mandateRepository.findById(id)
                        .orElseThrow(() -> new InvalidInput("Invalid Mandate Id")));
    }

    @Override
    public List<MandateDTO> getAllMandates() {
        return mandateMapper.toDtoList(mandateRepository.findAll());
    }

    @Override
    public void deleteMandate(Long id) {
        mandateRepository.findById(id)
                .orElseThrow(() -> new InvalidInput("Invalid Mandate Id"));
        mandateRepository.deleteById(id);
    }

    @Override
    public MandateDTO updateMandateById(Long id, MandateDTO mandateDTO) {
        if(!merchantRepository.existsById(mandateDTO.getMerchant())){
            throw new InvalidInput("Invalid Merchant");
        }
        if (!userRepository.existsById(mandateDTO.getCustomer())){
            throw new InvalidInput("Invalid Customer");
        }
        MandateEntity mandate = mandateRepository.findById(id)
                .orElseThrow(() -> new InvalidInput("Invalid Mandate Id"));
        mandateMapper.updateFromDto(mandateDTO, mandate);
        MandateEntity saveMandate = mandateRepository.save(mandate);
        return mandateMapper.toDto(saveMandate);
    }

    public boolean isMandateExists(UserEntity customer, MerchantEntity merchant) {
        return mandateRepository.existsByCustomerAndMerchant(customer, merchant);
    }
}
