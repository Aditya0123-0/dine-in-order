package com.example.dio.dto.request;

import com.example.dio.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot br blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can contain only Alphabets,numbers and underscore")
    private String username;

    @NotNull(message = "email must not be null")
    @NotBlank(message = "email cannot be blank")
    @Email(regexp = "^([\\w]*[\\w\\.]*(?!\\.)@gmail.com)$", message ="email must be in the form xyz@gmail.com")
    private String useremail;
//    The regular expression below cheks that a password:
//    Has minimum 8 characters in length. Adjust it by modifying {8,}
//    At least one uppercase English letter. You can remove this condition by removing (?=.*?[A-Z])
//    At least one lowercase English letter.  You can remove this condition by removing (?=.*?[a-z])
//    At least one digit. You can remove this condition by removing (?=.*?[0-9])
//    At least one special character,  You can remove this condition by removing (?=.*?[#?!@$%^&*-])
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Contain At least 8 character,At least one uppercase English letter," +
            "At least one lowercase English letter, "+"At least one digit, At least one special character")
    private String userpassword;

    @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Phone number must be in the format 8880344456\n" +
            "+918880344456 or 08880344456\n")
    private String userphoneNo;

    private UserRole userrole;
}
