package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.module.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
     UserResponse mapToUserResponse(User user) ;

     void mapUserToEntity(RegistrationRequest registrationRequest,@MappingTarget User user) ;

     void mapUserToEntity(UserRequest userRequest,@MappingTarget User user) ;
}
