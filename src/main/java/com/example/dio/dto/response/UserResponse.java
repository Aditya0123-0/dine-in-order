package com.example.dio.dto.response;

import com.example.dio.UserRole;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long userId;
    private String username;
    private UserRole userrole;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
}
