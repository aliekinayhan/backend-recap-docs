package com.ayhanekin.SpringDataJPA;

import com.ayhanekin.SpringDataJPA.model.Student;
import com.ayhanekin.SpringDataJPA.repo.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
        StudentRepository repository = context.getBean(StudentRepository.class);
        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);
        Student student3 = context.getBean(Student.class);

         repository.deleteById(4);


    }

}


//        Student student1 = context.getBean(Student.class);
//        Student student2 = context.getBean(Student.class);
//        Student student3 = context.getBean(Student.class);
//
//        student1.setRollNo(1);
//        student1.setName("Ali");
//        student1.setMarks(85);
//
//        student2.setRollNo(2);
//        student2.setName("Ekin");
//        student2.setMarks(70);
//
//        student3.setRollNo(3);
//        student3.setName("Ayhan");
//        student3.setMarks(80);
//
//        repository.save(student2);
//
//        System.out.println(repository.findAll());
//        System.out.println(repository.findById(2));
//
//        System.out.println(repository.findByName("ali"));
//        System.out.println(repository.findByMarks(80));
//        System.out.println(repository.findByMarksGreaterThan(70));
//
//        To update: repository.save(student1);
//
//
//