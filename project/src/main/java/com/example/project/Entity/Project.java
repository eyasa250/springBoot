package com.example.project.Entity;

import jakarta.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "Title")
    private  String Title;



    @Column(name="description")
    private  String email;


    @Column(name="budget")
    private  String budget;


    @Column(name="status")
    private  String status;

    @ManyToOne
    @JoinColumn(name="freelancer_id")
    private Freelancer freelancers;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="pr_id")
    private Project pr;



    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
