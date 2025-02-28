package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.module.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserid())
                .username(user.getUsername())
                .userrole(user.getUserrole())
                .createdAt(user.getCreatedAt())
                .lastModifiedAt(user.getLastModifiedAt())
                .build();
    }


    public void mapUserToEntity(RegistrationRequest registrationRequest, User user) {
        user.setUsername(registrationRequest.getUsername());
        user.setUseremail(registrationRequest.getUseremail());
        user.setUserpassword(registrationRequest.getUserpassword());
        user.setUserphoneNo(registrationRequest.getUserphoneNo());
        user.setUserrole(registrationRequest.getUserrole());
    }

    public void mapUserToEntity(UserRequest userRequest, User user) {
        user.setUsername(userRequest.getUsername());
        user.setUseremail(userRequest.getUseremail());
        user.setUserphoneNo(userRequest.getUserphoneNo());
    }
}
