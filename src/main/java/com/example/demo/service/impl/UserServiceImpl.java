package com.example.demo.service.impl;

import com.example.demo.model.UserEntity;
import com.example.demo.model.dto.UserLoginDTO;
import com.example.demo.model.dto.UserRegistrationDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setActive(true);
        userEntity.setFirstName(userRegistrationDTO.firstName());
        userEntity.setLastName(userRegistrationDTO.lastName());
        userEntity.setEmail(userRegistrationDTO.email());
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

        return userEntity;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        var userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

       boolean loginSuccess = false;

        if (userEntity != null) {

            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

             loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccess) {

                currentUser.setLogged(true);
                currentUser.setFirstName(userEntity.getFirstName());
                currentUser.setLastName(userEntity.getLastName());
            }else {
                currentUser.logout();
            }

        }
        return loginSuccess;
    }

    public void logoutUser(){
        currentUser.logout();
    }
}
