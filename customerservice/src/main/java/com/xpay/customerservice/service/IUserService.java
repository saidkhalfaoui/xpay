package com.xpay.customerservice.service;

import com.xpay.customerservice.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO saveUser(UserDTO UserEntity);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);
    UserDTO updateUserById(Long id, UserDTO userDTO);
    UserDTO findByIban(String iban);
    boolean isUserExists(String iban);

}
