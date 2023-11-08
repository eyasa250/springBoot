package com.example.project.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class WorkSample {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;



    @Column(name= "description")
    private  String description;
    @Column(name="title")
    private  String title;
    @Column(name="price")
    private  String price;

    @ManyToOne
    @JoinColumn(name="freelancer_id")
    private freelancer freelance;
    @ManyToMany (cascade = CascadeType.ALL)
    Set<Client> clients;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

