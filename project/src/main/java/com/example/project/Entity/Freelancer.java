package com.example.project.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Freelancer extends User {


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



}
