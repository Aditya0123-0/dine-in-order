package com.example.dio.module;


import com.example.dio.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userid;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String useremail;

    @Column(name = "password")
    private  String userpassword;

    @Column(name = "pho_no")
    private  String  userphoneNo;

    @Column(name = "role")
    private UserRole userrole;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private  LocalDate lastModifiedAt;
}
