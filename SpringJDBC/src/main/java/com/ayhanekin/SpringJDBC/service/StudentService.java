package com.ayhanekin.SpringJDBC.service;

import com.ayhanekin.SpringJDBC.model.Student;
import com.ayhanekin.SpringJDBC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;


    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public void addStudent(Student student) {
        System.out.println("Student Service has Called...");
        repository.add(student);
    }

    public StudentRepository getRepository() {
        return repository;
    }


    public List<Student> getStudents() {
        return repository.findAll();
    }
}
