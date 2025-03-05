package com.example.dio.controller;

import com.example.dio.Service.UserService;
import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.util.FieldErrorResponse;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import com.example.dio.util.SimpleErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
@Tag(name = "User Controller", description = "Collection API endpoints dealing with user data")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(description = """
            The API endpoint is used to register user.
            The endpoint requires the user to select one of the Specific role along with the other details.
            """ , responses = {
            @ApiResponse(responseCode = "201", description = "User Created"),
            @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                    @Content(schema = @Schema(implementation = FieldErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> register(@RequestBody @Valid RegistrationRequest registrationRequest){
        UserResponse response = userService.registerUser(registrationRequest);
        return ResponseBuilder.created( response,"Created User");
    }




    @GetMapping("/{userid}")
    @Operation(description = """
             The API endpoint is used to get the user using userid.
             The endpoint returns the details of user except users email, password and phone number.
             """,responses = {
            @ApiResponse(responseCode = "201", description = "Found User"),
            @ApiResponse(responseCode = "400", description = "Invalid userId", content = {
                    @Content(schema = @Schema(implementation = SimpleErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable Long userid){
        UserResponse response = userService.findUserById(userid);
        return  ResponseBuilder.ok(response,"Found User");
    }





    @PutMapping("/{userid}")
    @Operation(description = """
            The API endpoint is used to update the user data depending on userid.
            This endpoint allows user to update only Username , email, phone number and restrict the sensitive details form updating.
            """, responses = {
            @ApiResponse(responseCode = "201", description = "User Updated"),
            @ApiResponse(responseCode = "400", description = "Invalid Input" ,
            content = @Content(schema = @Schema(implementation = FieldErrorResponse.class))
            )
    })
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable Long userid, @RequestBody UserRequest request){
        UserResponse response = userService.updateUserById(userid,request);
        return ResponseBuilder.success(HttpStatus.OK,"User Updated",response);
    }


}

