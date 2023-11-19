package com.example.project.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Freelancer extends User {


    public Freelancer(String username, String email, String password, Role role, String nom) {
        super(username,email,password,role,nom);
    }

    public Freelancer() {

    }

    @Override
    public void resetPwd() {
    }

     @OneToMany(mappedBy = "freelance")
    private List<WorkSample>workSamples= new ArrayList<>();

    @OneToMany(mappedBy = "freelancers")
    private List<Project>projects= new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "freelancer_reviews",
            joinColumns = @JoinColumn(name = "freelancer_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<Review> reviews = new ArrayList<>();

    public static Freelancer createFreelancerObjectFromUser(User user) {
        return new Freelancer(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getFullname()
        );
    }

}
