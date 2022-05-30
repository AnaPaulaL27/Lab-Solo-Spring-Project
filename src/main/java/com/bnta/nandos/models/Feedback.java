package com.bnta.nandos.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//In most cases, the name of the table in the database and the name of the entity won't be the same.
//In these cases, we can specify the table name using the @Table annotation:
@Table(name = "customerFeedback")

public class Feedback {

    //properties (or "fields")
    //@Id defines primary key for this entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //sql will handle id for us + hibernate will communicate with sql to handle that
    //fine-tuning the way primary keys are generated

    //we want fields (columns)to be in table, hence mark it with @column
    //if changing column name do @Column(name = "xyz...")
    //the @column alone says it's a column in the table, but the latter case, providing name, instructs it to override
    // the name of "XYZ"

    @Column
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int rating;


    //relationship between Feedback + Nandoca- inverse
    @ManyToOne
    @JoinColumn(name = "nandoca_id")
    //property
    private Nandoca nandoca;

    //CONSTRUCTORS (2)

    //NO ARG CONSTRUCTOR- needed for underlying hibernate framework- uses it to create
    // an empty object + then it will set its fields
    protected Feedback() {};

    //ARG CONSTRUCTOR

    public Feedback(LocalDate date, String name, String description, int rating,  Nandoca nandoca) {
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

//note that:

//    The @Column annotation is only for properties which will be mapped to columns in the database table.
//    When we mark a property as @OneToMany, or @ManyToMany, that relationship is being handled by a separate
//    join table, which is created by Hibernate, and not persisted to a column in the table, which is why we omit
//    the @Column annotation in those instances.


//Model is just a class that is going to be used to create objects that are saved to a database