package com.henripay.customerservice.service;

import com.henripay.customerservice.dto.UserDTO;
import com.henripay.customerservice.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 *  @author: DevProblems(Sarang Kumar A Tak)
 *  Youtube channel: https://youtube.com/@devproblems
 */
@Service
public class UserService {

    private final Map<UUID, UserDTO> db = new ConcurrentHashMap<>();

    public UserDTO saveUser(UserDTO userDTO) {
        UUID uuid = UUID.randomUUID();
        userDTO.setId(uuid);
        db.put(uuid, userDTO);
        return userDTO;
    }

    public UserDTO getUser(UUID id) {

        return Optional.ofNullable(db.get(id))
                .orElseThrow(() -> new UserNotFoundException("User not found for Id: " + id));
    }

}
