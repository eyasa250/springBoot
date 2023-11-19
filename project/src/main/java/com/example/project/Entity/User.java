package com.example.project.Entity;

import jakarta.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "username")
    private  String username;
    @Column(name="email")
    private  String email;
    @Column(name="password")
    private  String password;

    @Column(name="role")
    private Role role;


    @Column(name="fullname")
    private  String fullname;

    public void resetPwd() {

    }


    public User(String username, String email, String password, Role role, String fullname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
