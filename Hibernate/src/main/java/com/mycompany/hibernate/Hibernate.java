package com.mycompany.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Hibernate {

    public static void main(String[] args) {

        // Database connection and hibernate configurations
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Transaction transaction = null;
        Session session = null;
        Session session2 = null;
        Alien alien;
        Alien alien2;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            alien = session.find(Alien.class, 3);
            System.out.println(alien);
            
            
            
            
            session2 = sessionFactory.openSession();
            alien2 = session2.find(Alien.class, 3);
            System.out.println(alien2);
            
            
            transaction.commit();
            session.close();
            session2.close();
            
                        

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }

    }
}

/*

        HQL
        Query<Student> query = session.createQuery("from Student where studentName = 'Ali'", Student.class);
        List<Student> students = query.getResultList();
        System.out.println(students);



        Veritabanına bağlanığ obje kaydetmek için böyle yapıyoruz 
        Veritabanında değişiklik yapılacaksa transaction kullanmak zorundayız 
        
        Student student = new Student();
        student.setStudentId(235196038);
        student.setStudentName("Ali Ekin");
        student.setStudentSurname("Ayhan");
        student.setStudentAge(23);



        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
 */
//         to fetch student = session.find(Student.class, 2);
 //         to update session.merge(student);
