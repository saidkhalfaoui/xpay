package com.henripay.customerservice.service.impl;

import com.henripay.customerservice.dto.UserDTO;
import com.henripay.customerservice.mapper.MerchantMapper;
import com.henripay.customerservice.mapper.UserMapper;
import com.henripay.customerservice.service.IUserService;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.domainservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
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
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userMapper.updateFromDto(userDTO, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO findByIban(String iban) {
        Optional<UserEntity> user = userRepository.findByIban(iban);
        return userMapper.toDto(user.orElseThrow(() -> new NotFoundException("Merchant not found")));
    }

    @Override
    public boolean isUserExists(String iban) {
        return userRepository.existsUserEntityByIban(iban);
    }
}
