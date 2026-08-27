package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LuanchDelete {
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
            count = session.createMutationQuery("DELETE FROM Student WHERE sid =:id")
                    .setParameter("id", "1").executeUpdate();
            flag = true;

        }catch (HibernateException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (flag) {
                transaction.commit();
                System.out.println("No of rows of deleted " + count);
            }else {
                assert transaction != null;
                transaction.rollback();
                System.out.println("No of rows of deleted " + count);
            }

            session.close();
            sessionFactory.close();
        }

    }
}
