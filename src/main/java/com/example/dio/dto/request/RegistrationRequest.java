package com.example.dio.dto.request;

import com.example.dio.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotNull
    @NotBlank
    private String username;
    private String useremail;
    private String userpassword;
    private String userphoneNo;
    private UserRole userrole;
}
