package com.studentProject.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentProject.model.Student;
import com.studentProject.model.Subject;
import com.studentProject.repository.StudentRepository;
import com.studentProject.repository.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;

    
    public Student createStudent(Student student) {
        // manage the subject entities
        Set<Subject> subjects = student.getSubjects();
        if (subjects != null) {
            for (Subject subject : subjects) {
                if (subject.getId() != null) {
                    // If subject already exists, fetch the managed entity
                    subject = subjectRepository.findById(subject.getId()).orElse(subject);
                } else {
                    // If subject does not exist, save the new subject
                    subject = subjectRepository.save(subject);
                }
            }
        }
        // Now save the student entity
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

