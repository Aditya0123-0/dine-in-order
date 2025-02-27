package com.example.dio.Service;

import com.example.dio.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService  {
    User registerUser(User user);
}
