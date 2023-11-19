package com.example.project.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Client extends User{


    public Client(String username, String email, String password, Role role, String nom) {
        super(username,email,password,role,nom);
    }

    public Client() {

    }

    @Override
    public void resetPwd() {

    }
    @OneToMany(mappedBy = "client")
    private List<Project> projects= new ArrayList<>();

    @ManyToMany (mappedBy = "clients")
    Set<WorkSample> Worksamples;

    @ManyToMany
    @JoinTable(
            name = "client_reviews",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<Review> reviews = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public static Client createClientObjectFromUser(User user) {
        return new Client(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getFullname()
        );
    }
}
