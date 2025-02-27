package com.example.dio.Service;

import com.example.dio.module.User;

public interface UserService  {
    User registerUser(User user);
    User findUserById(Long userid);

    User updateUserById(Long userid, User user);
}

