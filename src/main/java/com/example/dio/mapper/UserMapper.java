package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.module.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
     /**
      *  Converts a User entity to a UserResponse DTO
      * @param user entity to be converted.
      * @return UserResponse → The corresponding response DTO.
      */
     UserResponse mapToUserResponse(User user) ;

     /**
      * Maps data from a RegistrationRequest DTO to an existing User entity.
      * @param registrationRequest The DTO containing user registration details.
      * @param user  The existing User entity to be updated.
      */
     void mapUserToEntity(RegistrationRequest registrationRequest,@MappingTarget User user) ;

     /**
      *  Maps data from a UserRequest DTO to an existing User entity.
      * @param userRequest The DTO containing updated user details.
      * @param user The existing User entity to be updated.
      */
     void mapUserToEntity(UserRequest userRequest,@MappingTarget User user) ;
}
