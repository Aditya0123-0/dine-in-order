package com.example.dio.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot br blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can contain only Alphabets,numbers and underscore")
    private String username;

    @NotNull(message = "email must not be null")
    @NotBlank(message = "email cannot be blank")
    @Email(regexp = "^([\\w]*[\\w\\.]*(?!\\.)@gmail.com)$", message ="email must be in the form xyz@gmail.com")
    private String useremail;


    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Contain At least 8 character,At least one uppercase English letter," +
            "At least one lowercase English letter, "+"At least one digit, At least one special character")
    private  String  userphoneNo;

}
