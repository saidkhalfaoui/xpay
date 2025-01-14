package com.xpay.customerservice.service.impl;

import com.xpay.customerservice.dto.UserDTO;
import com.xpay.customerservice.mapper.UserMapper;
import com.xpay.customerservice.service.IUserService;
import com.xpay.domainservice.entity.UserEntity;
import com.xpay.common.exception.InvalidInput;
import com.xpay.domainservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if (isUserExists(userDTO.getIban())) {
            return findByIban(userDTO.getIban());
        }
        UserEntity merchant = userMapper.toEntity(userDTO);
        UserEntity savedMerchant = userRepository.save(merchant);
        return userMapper.toDto(savedMerchant);
    }

    @Override
    public UserDTO getUserById(Long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new InvalidInput("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new InvalidInput("User not found"));
        userRepository.deleteById(user.getCustomerIdIdentifier());
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new InvalidInput("User not found"));
        userMapper.updateFromDto(userDTO, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO findByIban(String iban) {
        Optional<UserEntity> user = userRepository.findByIban(iban);
        return userMapper.toDto(user.orElseThrow(() -> new InvalidInput("Merchant not found")));
    }

    @Override
    public boolean isUserExists(String iban) {
        return userRepository.existsUserEntityByIban(iban);
    }
}
