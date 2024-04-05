package com.henripay.customerservice.service.impl;
import com.henripay.customerservice.dto.UserDTO;
import com.henripay.customerservice.mapper.UserMapper;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.exception.InvalidInput;
import com.henripay.domainservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);}
    @Test
    public void saveUser_NewUser_Success() {
        // Given
        UserDTO userDTO = new UserDTO();
        userDTO.setIban("IBAN123");
        UserEntity userEntity = new UserEntity();
        userEntity.setIban("IBAN123");

        when(userRepository.existsUserEntityByIban(userDTO.getIban())).thenReturn(false);
        when(userMapper.toEntity(userDTO)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDto(userEntity)).thenReturn(userDTO);

        // When
        UserDTO savedUser = userService.saveUser(userDTO);

        // Then
        verify(userRepository, times(1)).existsUserEntityByIban(userDTO.getIban());
        verify(userRepository, times(1)).save(userEntity);
        verify(userMapper, times(1)).toEntity(userDTO);
        verify(userMapper, times(1)).toDto(userEntity);
        assertEquals(userDTO, savedUser);
    }

    @Test
    public void saveUser_ExistingUser_Success() {
        // Given
        UserDTO userDTO = new UserDTO();
        userDTO.setIban("IBAN123");
        UserEntity userEntity = new UserEntity();
        userEntity.setIban("IBAN123");

        when(userRepository.existsUserEntityByIban(userDTO.getIban())).thenReturn(true);
        when(userRepository.findByIban(userDTO.getIban())).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(userEntity)).thenReturn(userDTO);

        // When
        UserDTO existingUser = userService.saveUser(userDTO);

        // Then
        verify(userRepository, times(1)).existsUserEntityByIban(userDTO.getIban());
        verify(userRepository, never()).save(any());
        verify(userRepository, times(1)).findByIban(userDTO.getIban());
        verify(userMapper, times(1)).toDto(userEntity);
        assertEquals(userDTO, existingUser);
    }

    @Test
    public void getUserById_ExistingUser_Success() {
        // Given
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();
        userDTO.setCustomerIdIdentifier(userId);
        UserEntity userEntity = new UserEntity();
        userEntity.setCustomerIdIdentifier(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(userEntity)).thenReturn(userDTO);

        // When
        UserDTO retrievedUser = userService.getUserById(userId);

        // Then
        verify(userRepository, times(1)).findById(userId);
        verify(userMapper, times(1)).toDto(userEntity);
        assertEquals(userDTO, retrievedUser);
    }

    @Test
    public void getUserById_NonExistingUser_ThrowsException() {
        // Given
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(InvalidInput.class, () -> userService.getUserById(userId));
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void getAllUsers_UsersExist_Success() {
        // Given
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        userEntities.add(new UserEntity());
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(new UserDTO());
        userDTOs.add(new UserDTO());

        when(userRepository.findAll()).thenReturn(userEntities);
        when(userMapper.toDtoList(userEntities)).thenReturn(userDTOs);

        // When
        List<UserDTO> allUsers = userService.getAllUsers();

        // Then
        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(1)).toDtoList(userEntities);
        assertEquals(userDTOs, allUsers);
    }

    @Test
    public void deleteUser_ExistingUser_Success() {
        // Given
        Long userId = 1L;
        UserEntity userEntity = new UserEntity();
        userEntity.setCustomerIdIdentifier(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void deleteUser_NonExistingUser_ThrowsException() {
        // Given
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(InvalidInput.class, () -> userService.deleteUser(userId));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).deleteById(userId);
    }

    @Test
    public void updateUserById_ExistingUser_Success() {
        // Given
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();
        userDTO.setCustomerIdIdentifier(userId);
        UserEntity userEntity = new UserEntity();
        userEntity.setCustomerIdIdentifier(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDto(userEntity)).thenReturn(userDTO);

        // When
        UserDTO updatedUser = userService.updateUserById(userId, userDTO);

        // Then
        verify(userRepository, times(1)).findById(userId);
        verify(userMapper, times(1)).updateFromDto(userDTO, userEntity);
        verify(userRepository, times(1)).save(userEntity);
        verify(userMapper, times(1)).toDto(userEntity);
        assertEquals(userDTO, updatedUser);
    }

    @Test
    public void updateUserById_NonExistingUser_ThrowsException() {
        // Given
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(InvalidInput.class, () -> userService.updateUserById(userId, userDTO));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any());
        verify(userMapper, never()).toDto(any());
    }

    @Test
    public void findByIban_ExistingUser_Success() {
        // Given
        String iban = "IBAN123";
        UserDTO userDTO = new UserDTO();
        userDTO.setIban(iban);
        UserEntity userEntity = new UserEntity();
        userEntity.setIban(iban);

        when(userRepository.findByIban(iban)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(userEntity)).thenReturn(userDTO);

        // When
        UserDTO foundUser = userService.findByIban(iban);

        // Then
        verify(userRepository, times(1)).findByIban(iban);
        verify(userMapper, times(1)).toDto(userEntity);
        assertEquals(userDTO, foundUser);
    }
}
