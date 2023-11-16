package com.example.project.servives;

import com.example.project.Entity.Freelancer;
import com.example.project.Entity.User;
import com.example.project.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImp implements FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Override
    public Freelancer getFreelancerByNom(String nom) {
        return freelancerRepository.getFreelancerByNom(nom);
    }

    @Override
    public List<Freelancer> getAllFreelancer() {
        return freelancerRepository.findAll();
    }

    @Override
    public Freelancer createFreelancer(Freelancer user) {
        return freelancerRepository.save(user);
    }

    @Override
    public Freelancer getFreelancerByID(Long id) {
        return freelancerRepository.findById(id).get();
    }

    @Override
    public Freelancer updateFreelancer(Freelancer user) {
        return freelancerRepository.saveAndFlush(user);
    }

    @Override
    public void deleteFreelancer(long id) {
        freelancerRepository.deleteById(id);
    }
}
