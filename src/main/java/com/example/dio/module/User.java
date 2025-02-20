package com.example.dio.module;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long userid;
    private String username;
    private String useremail;
    private  String userpassword;
    private  int userphoneNo;
    private  String userrole;
    private LocalDate createdAt;
    private  LocalDate lastModifiedAt;
}
