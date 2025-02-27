package com.example.dio.Service.impl;

import com.example.dio.Service.UserService;
import com.example.dio.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
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
    @Override
    public User registerUser(User user) {
        User user1= this.getUser(user.getUserrole());
        this.mapToNewUser(user, user1);
        return userRepository.save(user1);
    }

    @Override
    public User findUserById(Long userid) {
        return userRepository.findById(userid)
                .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
    }

    @Override
    public User updateUserById(Long userid, User user) {
        User exsistingUser = userRepository.findById(userid)
                .orElseThrow(()->new UserNotFoundByIdException("Failed to find User, User not found by Id"));
        this.mapToNewUser(user,exsistingUser);
        return userRepository.save(exsistingUser);
    }


    private  User getUser(UserRole role) {
        User user ;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            case null, default -> throw new RuntimeException("Failed to register User, Invalide User");
        }
        return user;
    }

    private  void mapToNewUser(User user, User user1) {
        user1.setUsername(user.getUsername());
        user1.setUseremail(user.getUseremail());
        user1.setUserpassword(user.getUserpassword());
        user1.setUserrole(user.getUserrole());
        user1.setUserphoneNo(user.getUserphoneNo());
    }
}
