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
        config.configure();

        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();

        Student student = new Student();
//        student.setSid(2);
        student.setsName("Aseka");
        student.setScity("Colombo");

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
