package com.bnta.nandos.repositories;

import com.bnta.nandos.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}

//Repository for Feedback model
//it extends JPARepository
//pass in 'type' arguments - it deals with Feedback type + you have to give the
//type of the primary key which is Long
//That is all you need to do to get started, for hibernate to get a basic repository up + running
//but then you can come back + add extra things.