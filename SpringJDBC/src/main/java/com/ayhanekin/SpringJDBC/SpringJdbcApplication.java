package com.ayhanekin.SpringJDBC;

import com.ayhanekin.SpringJDBC.model.Student;
import com.ayhanekin.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        StudentService service = context.getBean(StudentService.class);


        Student student = context.getBean(Student.class);

        student.setName("Ali Ayhan");
        student.setRollNo(635);
        student.setMarks(85);

        service.addStudent(student);

        List <Student> students = service.getStudents();
        System.out.println(students);


    }

}
