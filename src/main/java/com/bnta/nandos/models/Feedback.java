package com.bnta.nandos.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Feedback {

    //properties (or "fields")
    //@Id defines primary key for this entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate date;
    private String name;
    private String description;
    private int rating;

    //relationship between Feedback + Nandoca- inverse
    @ManyToOne
    //property
    private Nandoca nandoca;

    //Constructors (2)

    //no arg constructor- needed for underlying hibernate framework- uses it to create
    // an empty object + then it will set its fields
    public Feedback() {};

    //arg constructor


    public Feedback(LocalDate date, String name, String description, int rating, Nandoca nandoca) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nandoca = nandoca;
    }

    //Getters + Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Nandoca getNandoca() {
        return nandoca;
    }

    public void setNandoca(Nandoca nandoca) {
        this.nandoca = nandoca;
    }
}
