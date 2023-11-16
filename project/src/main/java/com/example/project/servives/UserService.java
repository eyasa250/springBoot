package com.example.project.servives;

import com.example.project.Entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean findByUsernamePassword(String username, String password);
}
