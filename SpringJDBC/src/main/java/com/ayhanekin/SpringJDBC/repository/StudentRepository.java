package com.ayhanekin.SpringJDBC.repository;

import com.ayhanekin.SpringJDBC.model.Student;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void add(@NonNull Student student) {
        String sql = "insert into student (rollNo, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        return jdbc.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollNo"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));

            return student;

        });
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
}
