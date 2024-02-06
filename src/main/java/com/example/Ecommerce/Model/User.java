package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "ecommerce_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_first_name")
    private String fname;

    @Column(name = "user_last_name")
    private String lname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_dob")
    private String dob;

    @Column(name = "user_phone")
    private int phoneno;
}
