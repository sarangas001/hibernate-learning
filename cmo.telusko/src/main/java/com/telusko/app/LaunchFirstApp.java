package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main(String[] args) {
        // Step 01: Configuration Object
        Configuration config = new Configuration();

        // Step 02: configure hibernate.cfg.xml file to Configuration Object
        config.configure();

        // Step 03: Create SesionFactory Object
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Step 04: Get the session Object from session factory
        Session session = sessionFactory.openSession();

        // Step 05 Begin the transaction with Session
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setSid(1);
        student.setsName("Saranga");
        student.setScity("Bengaluru");

        // Setp 06: Perform Operation
        session.save(student);

        // Step 07 Performing Transaction operations
        transaction.commit();

        // Step 08 Close the session
        session.close();

    }
}
