package com.henripay.mandateservice.service.Impl;

import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.repository.MandateRepository;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.domainservice.repository.UserRepository;
import com.henripay.mandateservice.dto.MandateDTO;
import com.henripay.mandateservice.mapper.MandateMapper;
import com.henripay.mandateservice.service.IMandateService;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;

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
        if(!merchantRepository.existsById(mandateDTO.getMerchant()) || !userRepository.existsById(mandateDTO.getCustomer())){
            throw new BadRequestException("Bad Request");
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
                        .orElseThrow(() -> new NotFoundException("Mandate not found")));
    }

    @Override
    public List<MandateDTO> getAllMandates() {
        return mandateMapper.toDtoList(mandateRepository.findAll());
    }

    @Override
    public void deleteMandate(Long id) {
        mandateRepository.deleteById(id);
    }

    @Override
    public MandateDTO updateMandateById(Long id, MandateDTO mandateDTO) {
        MandateEntity mandate = mandateRepository.findById(id).orElseThrow(() -> new BadRequestException("Bad Request"));
        mandateMapper.updateFromDto(mandateDTO, mandate);
        return mandateMapper.toDto(mandateRepository.save(mandate));
    }

    public boolean isMandateExists(UserEntity customer, MerchantEntity merchant) {
        return mandateRepository.existsByCustomerAndMerchant(customer, merchant);

    }
}
