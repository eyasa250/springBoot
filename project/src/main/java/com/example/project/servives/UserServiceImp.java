package com.example.project.servives;
import com.example.project.Entity.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean findByUsernamePassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user == null) return false;
        else return true;
    }
}
