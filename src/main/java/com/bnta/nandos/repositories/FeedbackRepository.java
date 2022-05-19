package com.bnta.nandos.repositories;

import com.bnta.nandos.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}



//JPaRepository is a generic class that takes any datatype, we provided a Feedback datatype and Long datatype
// These come from @Entity class (class annotated with Entity), + @Entity class field (the datatype of the field
// annotated with @ID in the class with @Entity annotation)

// 'extends' means that this FeedbackRepository extends jpaRepository, so it implements all methods of the of that
// JPARepository class which allows us
// to perform operations like findAll(), getByID(ID id) etc (like inheritance)

//---
//Repository for Feedback model
//it extends JPARepository
//pass in 'type' arguments - it deals with Feedback type + you have to give the
//type of the primary key which is Long
//That is all you need to do to get started, for hibernate to get a basic repository up + running
//but... then you can come back + add extra things