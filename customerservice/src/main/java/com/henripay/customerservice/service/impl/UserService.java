package com.henripay.customerservice.service.impl;

import com.henripay.customerservice.dto.UserDTO;
import com.henripay.customerservice.mapper.UserMapper;
import com.henripay.customerservice.service.IUserService;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.exception.InvalidInput;
import com.henripay.domainservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if(isUserExists(userDTO.getIban())){
            return findByIban(userDTO.getIban());
        }
        UserEntity merchant = userMapper.toEntity(userDTO);
        UserEntity savedMerchant =  userRepository.save(merchant);
        return userMapper.toDto(savedMerchant);
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<UserEntity> merchant = userRepository.findById(id);
        return  userMapper.toDto(merchant.orElseThrow(() -> new InvalidInput("User not found")));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new InvalidInput("User not found"));
        userRepository.deleteById(id);
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