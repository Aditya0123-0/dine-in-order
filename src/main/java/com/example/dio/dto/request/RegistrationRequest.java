package com.example.dio.dto.request;

import com.example.dio.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotEmpty(message = "Email cannot be null ")
    @NotBlank(message = "Email cannot br blank")
    private String useremail;

    private String userpassword;
    private String userphoneNo;
    private UserRole userrole;
}
