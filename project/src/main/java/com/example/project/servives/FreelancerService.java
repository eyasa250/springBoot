package com.example.project.servives;


import com.example.project.Entity.Freelancer;
import com.example.project.dto.UserDto;

import java.util.List;

public interface FreelancerService {

    Freelancer getFreelancerByFullname(String fullname);

    List<Freelancer> getAllFreelancer();

    Freelancer createFreelancer(UserDto user);

    Freelancer getFreelancerByID(Long id);

    Freelancer updateFreelancer(Freelancer client);

    void deleteFreelancer(long id);


}
