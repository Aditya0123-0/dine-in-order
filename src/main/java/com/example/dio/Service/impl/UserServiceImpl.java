package com.example.dio.Service.impl;

import com.example.dio.Service.UserService;
import com.example.dio.module.User;
import com.example.dio.repositiory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
