package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LanuchStandardApp {
    public static void main(String[] args) {

        // configuration
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        config = new Configuration();
        config.configure();

        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();


        try {
            // SELECT * FROM studenttable;
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> listStudent = query.list();

//            for(Student s: listStudent) {
//                System.out.println(s);
//            }
            listStudent.forEach(System.out::println);

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
