package com.studentProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentProject.model.Student;
import com.studentProject.model.Subject;
import com.studentProject.repository.SubjectRepository;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

	public Subject createStudent(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}
}

