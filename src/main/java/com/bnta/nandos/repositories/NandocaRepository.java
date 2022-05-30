package com.bnta.nandos.repositories;

import com.bnta.nandos.models.Nandoca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NandocaRepository extends JpaRepository<Nandoca, Long> {


// find all nandocas with name Sandra
    List<Nandoca> findNandocaByNameContainingIgnoreCase(String name);

// find all nandocas with years of experience greater than 2
    List<Nandoca> findNandocaByYearsExperienceGreaterThan(int yearsExperience);

}


//JPaRepository is a generic class that takes any datatype, we provided a Feedback datatype and Long datatype
// These come from @Entity class (class annotated with Entity), + @Entity class field (the datatype of the field
// annotated with @ID in the class with @Entity annotation)

// 'extends' means that this NandocaRepository extends jpaRepository, so it implements all methods of the of that
// JPARepository class which allows us
// to perform operations like findAll(), getByID(ID id) etc (like inheritance)

//---
//Repository for Nandoca model
//it extends JPARepository
//pass in 'type' arguments - it deals with Nandoca type + you have to give the
//type of the primary key which is Long
//That is all you need to do to get started, for hibernate to get a basic repository up + running
//but... then you can come back + add extra things