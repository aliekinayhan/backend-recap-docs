package com.ayhanekin.SpringDataJPA.repo;

import com.ayhanekin.SpringDataJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
        /*
        Spring Jpa uses DSL (Domain Specific Language) it means there is some queries are
        pre-created so we don't have to write extra query for those
        */



        @Query("select student from Student student where student.name = ?1")
        List<Student> findByName(String name);

        List<Student> findByMarks(int mark);

        List<Student> findByMarksGreaterThan(int mark);


        void deleteById(int studentId);
}
