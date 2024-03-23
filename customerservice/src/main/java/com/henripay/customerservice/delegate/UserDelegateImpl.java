package com.henripay.customerservice.delegate;

import com.henripay.customerservice.controller.UsersApiDelegate;
import com.henripay.customerservice.dto.UserDTO;
import com.henripay.customerservice.service.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDelegateImpl implements UsersApiDelegate {

    private final UserService userService;

    public UserDelegateImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long customerIdIdentifier) {
        userService.deleteUser(customerIdIdentifier);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long customerIdIdentifier) {
        return ResponseEntity.ok(userService.getUserById(customerIdIdentifier));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long customerIdIdentifier, UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserById(customerIdIdentifier, userDTO));
    }
}
