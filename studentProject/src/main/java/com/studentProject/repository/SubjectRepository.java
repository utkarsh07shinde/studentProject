package com.studentProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentProject.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}

