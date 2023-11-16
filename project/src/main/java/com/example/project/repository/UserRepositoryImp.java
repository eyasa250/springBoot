package com.example.project.repository;

import com.example.project.Entity.Freelancer;
import com.example.project.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserRepositoryImp {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public User findByUsernameAndPassword(String username,String password) {
        Query query=entityManager.createNativeQuery("SELECT U.username FROM User U"+
                "WHERE U.username LIKE ? AND U.password LIKE ?", User.class);
        query.setParameter( 1, username +"%");
        query.setParameter( 2, password +"%");
        return (User) query.getSingleResult();

    }
}
