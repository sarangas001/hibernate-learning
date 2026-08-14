package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LanuchStandardAp {
    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        config = new Configuration();

//        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver" );
//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/telusko_db");
//        config.setProperty("hibernate.connection.username", "root");
//        config.setProperty("hibernate.connection.password", "root");
//        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        config.setProperty("hibernate.show_sql", "true");
//        config.setProperty("hibernate.format_sql", "true");
//        config.setProperty("hibernate.hbm2ddl.auto", "update");



        config.addAnnotatedClass(Student.class);


        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();

        Student student = new Student();
        student.setSid(3);
        student.setsName("Ravindu");
        student.setScity("Mahara");

        try {
            transaction = session.beginTransaction();
            session.persist(student);
            flag = true;

        }catch (HibernateException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (flag) {
                transaction.commit();
            }else {
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }

    }
}
