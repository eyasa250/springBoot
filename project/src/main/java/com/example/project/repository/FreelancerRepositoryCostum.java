package com.example.project.repository;

import com.example.project.Entity.Freelancer;

public interface FreelancerRepositoryCostum {

    Freelancer getFreelancerByNom(String nom);

    boolean existsByEmailLike(String email);

    boolean existsByUsernameLike (String username);


}
