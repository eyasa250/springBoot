package com.example.project.repository;

import com.example.project.Entity.Freelancer;

public interface FreelancerRepositoryCostum {

    Freelancer getFreelancerByFullname(String fullname);

    boolean existsByEmailLike(String email);

    boolean existsByUsernameLike (String username);


}
