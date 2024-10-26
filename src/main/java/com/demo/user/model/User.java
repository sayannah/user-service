package com.demo.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "userdetails")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean active;
}
