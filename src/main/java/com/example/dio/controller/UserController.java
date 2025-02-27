package com.example.dio.controller;

import com.example.dio.Service.UserService;
import com.example.dio.module.User;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseStructure<User>> register(@RequestBody User user){
        user = userService.registerUser(user);

        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setData(user);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("User Created");

        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
    }
}
