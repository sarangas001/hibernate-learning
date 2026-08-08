package com.telusko.app;

import com.telusko.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchSelective
{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Employee e = new Employee();
            e.setEage(23);
            e.setEid(1);
            e.seteName("Saranga");
            e.setEcity("Mahara");
            session.persist(e);
            flag = true;

        }catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (flag)
                transaction.commit();
            else
                transaction.rollback();
            session.close();

        }
    }
}
