package com.ayhanekin.SpringSecurity.controller;


import com.ayhanekin.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("students")
    public List<Student> getStudents () {
        return students;
    }

    @GetMapping("csrf")
    public CsrfToken getCsrf (HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("students")
    public Student addStudent (@RequestBody Student student) {
        students.add(student);
        return student;
    }

























    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Ali Yılmaz", "Java"),
            new Student(2, "Ayşe Demir", "Python"),
            new Student(3, "Mehmet Kaya", "Spring Boot"),
            new Student(4, "Zeynep Çelik", "React"),
            new Student(5, "Ahmet Şahin", "Node.js"),
            new Student(6, "Elif Arslan", "Angular"),
            new Student(7, "Burak Yıldız", "Docker"),
            new Student(8, "Fatma Koç", "Kubernetes"),
            new Student(9, "Can Aydın", "Go"),
            new Student(10, "Selin Kurt", "C#"),
            new Student(11, "Emre Özkan", "PostgreSQL"),
            new Student(12, "Merve Aksoy", "MongoDB"),
            new Student(13, "Kerem Güneş", "Redis"),
            new Student(14, "Deniz Polat", "AWS"),
            new Student(15, "Ozan Tekin", "Microservices")
    )) ;


}
