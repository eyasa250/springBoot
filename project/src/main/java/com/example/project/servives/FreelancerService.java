package com.example.project.servives;


import com.example.project.Entity.Freelancer;

import java.util.List;

public interface FreelancerService {

    Freelancer getFreelancerByNom(String nom);

    List<Freelancer> getAllFreelancer();

    Freelancer createFreelancer(Freelancer client);

    Freelancer getFreelancerByID(Long id);

    Freelancer updateFreelancer(Freelancer client);

    void deleteFreelancer(long id);


}
