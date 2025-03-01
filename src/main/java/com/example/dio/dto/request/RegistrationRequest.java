package com.example.dio.dto.request;

import com.example.dio.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String username;
    private String useremail;
    private String userpassword;
    private String userphoneNo;
    private UserRole userrole;
}
