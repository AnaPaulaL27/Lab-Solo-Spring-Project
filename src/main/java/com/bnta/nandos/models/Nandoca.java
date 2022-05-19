package com.bnta.nandos.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//superpower given to class- uses hibernate under the hood which maps objects of this class to row
//in relational database table
@Entity
public class Nandoca {

    //properties (or "fields)
    //@Id defines primary key for this entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //sql will handle id for us + hibernate will communicate with sql to handle that
    //fine-tuning the way primary keys are generated

    //we want fields (columns)to be in table, hence mark it with @column
    //if changing column name do @Column(name = "xyz...") + avoid trouble
    //the @column alone says it's a column in the table, but the latter case, providing name, instructs it to override
    // the name of "XYZ"

    @Column
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private LocalDate DOB;

    @Column
    private int yearsExperience;

    @Column
    private int employeeNumber;


    //relationship between Nandoca+ Feedback- One-many-  a Nandoca can have many feedbacks, but a feedback can only go to one Nandoca
    @OneToMany(mappedBy = "nandoca", cascade = CascadeType.ALL) //this "cascade" variable will allow us to save a list of
    //Feedback objects named "customerFeeback" + assign it to a Nandoca
    //property
    private List<Feedback> customerFeedback; //what is customer feedback saying about Nandoca

    //constructors (2)

    //no arg constructor- needed for underlying hibernate framework- uses it to create
    // an empty object + then it will set its fields
    public Nandoca(){};

    //arg constructor
    //did not pass id nor list through constructor, will add objects later in config-> databaseSeeder (DBSeeder)
    public Nandoca(String firstname, String lastname, LocalDate DOB, int yearsExperience, int employeeNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.DOB = DOB;
        this.yearsExperience = yearsExperience;
        this.employeeNumber = employeeNumber;
        this.customerFeedback = new ArrayList<Feedback>();
    }

    //Getters + Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Feedback> getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(List<Feedback> customerFeedback) {
        this.customerFeedback = customerFeedback;
    }
}


//note that:

//    “The @Column annotation is only for properties which will be mapped to columns in the database table.
//    When we mark a property as @OneToMany, or @ManyToMany, that relationship is being handled by a separate
//    join table, which is created by Hibernate, and not persisted to a column in the table, which is why we omit
//    the @Column annotation in those instances.”
