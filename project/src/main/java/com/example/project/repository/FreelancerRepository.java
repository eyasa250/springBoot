package com.example.project.repository;

import com.example.project.Entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer,Long>,FreelancerRepositoryCostum{
}
