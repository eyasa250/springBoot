package com.example.project.repository;

import com.example.project.Entity.Client;

public interface ClientRepositoryCostum {

    Client getClientByNom(String nom);

    boolean existsByEmailLike(String email);

    boolean existsByUsernameLike(String username);
}
