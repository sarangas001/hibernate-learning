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
        int count = 0;

                config = new Configuration();
        config.configure();

        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();


        try {
            transaction = session.beginTransaction();
//            count = session.createQuery("UPDATE Student SET scity=:city")
//                    .setParameter("city", "Mahara").executeUpdate();
            count = session.createMutationQuery("UPDATE Student SET scity=:city WHERE sname =:name")
                    .setParameter("city", "Colombo").setParameter("name", "Aseka").executeUpdate();
            flag = true;

        }catch (HibernateException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (flag) {
                transaction.commit();
                System.out.println("No of rows of updated " + count);
            }else {
                transaction.rollback();
                System.out.println("No of rows of updated " + count);
            }

            session.close();
            sessionFactory.close();
        }

    }
}
