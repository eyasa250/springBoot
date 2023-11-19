package com.example.project.repository;

import com.example.project.Entity.Client;

public interface ClientRepositoryCostum {

    Client getClientByFullname(String fullname);

    boolean existsByEmailLike(String email);

    boolean existsByUsernameLike(String username);
}
