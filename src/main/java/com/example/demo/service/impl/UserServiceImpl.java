package com.example.demo.service.impl;

import com.example.demo.model.UserEntity;
import com.example.demo.model.dto.UserRegistrationDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setActive(true);
        userEntity.setFirstName(userRegistrationDTO.firstName());
        userEntity.setLastName(userRegistrationDTO.lastName());
        userEntity.setEmail(userRegistrationDTO.email());
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));


        return userEntity;
    }
}
