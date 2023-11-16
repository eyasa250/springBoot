package com.example.project.repository;

import com.example.project.Entity.Client;
import com.example.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long>,UserRepositoryCostum {

}
