/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author Ali Ekin Ayhan
 */

@Entity
public class Student {

    @Id
    int studentId;
    
    String studentName;
    String studentSurname;
    int studentAge;  

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Studentt{" + "studentId=" + studentId + ", studentName=" + studentName + ", studentSurname=" + studentSurname + ", studentAge=" + studentAge + '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    
    
    
    
    
}
