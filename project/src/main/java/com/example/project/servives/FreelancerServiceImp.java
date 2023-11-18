package com.example.project.servives;

import com.example.project.Entity.Freelancer;
import com.example.project.Entity.User;
import com.example.project.Exception.ApiRequestException;
import com.example.project.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project.Validator.EmailValidator;

import java.util.List;

@Service
public class FreelancerServiceImp implements FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private EmailValidator emailValidator;
    @Override
    public Freelancer getFreelancerByNom(String nom) {
        return freelancerRepository.getFreelancerByNom(nom);
    }

    @Override
    public List<Freelancer> getAllFreelancer() {
        return freelancerRepository.findAll();
    }

    @Override
    public Freelancer createFreelancer(Freelancer freelancer) {
        if (!emailValidator.test(freelancer.getEmail())) {
            throw new ApiRequestException("Email is not valid");
        }

        if (freelancerRepository.existsByEmailLike(freelancer.getEmail())) {
            throw new ApiRequestException("Email is already taken");
        }

        if (freelancerRepository.existsByEmailLike(freelancer.getUsername())) {
            throw new ApiRequestException("Username is already taken");
        }

        return freelancerRepository.save(freelancer);
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
