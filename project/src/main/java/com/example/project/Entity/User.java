package com.example.project.Entity;

import jakarta.persistence.*;
@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "username")
    private  String username;
    @Column(name="email")
    private  String email;
    @Column(name="password")
    private  String password;
    public abstract void resetPwd();

}
