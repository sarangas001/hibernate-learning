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
            // SELECT * FROM studenttable WHERE scity=?;
//            Query<Student> query = session.createQuery("FROM Student WHERE scity =:city", Student.class);
            Query<String> query = session.createQuery("SELECT sname FROM Student WHERE scity IN(:city1, :city2)", String.class);
            query.setParameter("city1", "Colombo");
            query.setParameter("city2", "Mahara");
            List<String> listStudent = query.list();

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

            session.close();
            sessionFactory.close();
        }

    }
}
