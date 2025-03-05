package com.example.dio.Service.impl;

import com.example.dio.Service.UserService;
import com.example.dio.UserRole;
import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.module.Admin;
import com.example.dio.module.Staff;
import com.example.dio.module.User;
import com.example.dio.repositiory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user= this.getUser(registrationRequest.getUserrole());
        userMapper.mapUserToEntity(registrationRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse findUserById(Long userid) {
        User user=userRepository.findById(userid)
                .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
        return userMapper.mapToUserResponse(user);

        /* Using Lamda expression
        * userRepository.findById(userid)
        *       .map(userMapper::mapToUserResponse)
        *    .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
        * */
    }

    @Override
    public UserResponse updateUserById(Long userid, UserRequest request) {
        User exsistingUser = userRepository.findById(userid)
                .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
        userMapper.mapUserToEntity(request,exsistingUser);
        userRepository.save(exsistingUser);
        return userMapper.mapToUserResponse(exsistingUser);

        /* Uisng Lamda Expression
        * userRepository.findById(userid)
                .map(User exUser ->{
                userMapper.mapUserToEntity(userRequest,exUser);
                userRepository.save(exUser);
                return userMapper.mapToUserResponse(exUser)
                .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
        * */
    }


    /**
     * This method creates and returns an instance of a specific User subtype based on the provided UserRole.
     * If the role is ADMIN, it returns an Admin instance.
     * If the role is STAFF, it returns a Staff instance.
     * If the role is null or an unrecognized value, it throws a RuntimeException.
     * @param role The role of the user, which determines the type of User to be created.
     * @return An instance of either Admin or Staff, depending on the role.
     */
    private  User getUser(UserRole role) {
        User user ;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            case null, default -> throw new RuntimeException("Failed to register User, Invalid User");
        }
        return user;
    }
}
