package com.example.project.repository;

import com.example.project.Entity.User;

public interface UserRepositoryCostum {
    User findByUsernameAndPassword(String username, String password);
}
