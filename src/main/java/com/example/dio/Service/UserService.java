package com.example.dio.Service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;

public interface UserService  {
    UserResponse registerUser(RegistrationRequest registrationRequest);
    UserResponse findUserById(Long userid);
    UserResponse updateUserById(Long userid, UserRequest request);
}

