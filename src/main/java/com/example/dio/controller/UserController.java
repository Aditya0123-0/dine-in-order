package com.example.dio.controller;

import com.example.dio.Service.UserService;
import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseStructure<UserResponse>> register(@RequestBody @Valid RegistrationRequest registrationRequest){
        UserResponse response = userService.registerUser(registrationRequest);
        return ResponseBuilder.success(HttpStatus.CREATED,"Created User", response);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable Long userid){
        UserResponse response = userService.findUserById(userid);
        return  ResponseBuilder.success(HttpStatus.OK,"Found User",response);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable Long userid, @RequestBody UserRequest request){
        UserResponse response = userService.updateUserById(userid,request);
        return ResponseBuilder.success(HttpStatus.OK,"User Updated",response);
    }


}

