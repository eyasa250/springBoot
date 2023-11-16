package com.example.project.Entity;

import jakarta.persistence.*;

@Entity
public abstract class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @Column(name= "note")
    private  int note;
    @Column(name="comment")
    private  String email;

    @ManyToOne
    @JoinColumn(name="freelancer_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;


    public abstract void calculReview();



}
