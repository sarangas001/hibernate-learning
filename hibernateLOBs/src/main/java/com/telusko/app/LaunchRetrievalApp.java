package com.telusko.app;

import com.telusko.model.StudentInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.*;

public class LaunchRetrievalApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfo.class).buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        FileOutputStream fos = null;
        FileWriter writer = null;

        try {
            session = sessionFactory.openSession();


            StudentInfo studentInfo = session.get(StudentInfo.class, 1);

            fos = new FileOutputStream("Java.png");
            writer = new FileWriter("doc.txt");
            fos.write(studentInfo.getImage());
            char[] chars = studentInfo.getTextFile();

            writer.write(chars);

        }catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally { 

            try {
                fos.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sessionFactory.close();
            session.close();

        }
    }
}
