package com.example.demo.service.impl;

import com.example.demo.model.dto.UserRegistrationDTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        System.out.println(userRegistrationDTO );
    }
}
