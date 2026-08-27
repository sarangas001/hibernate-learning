package com.telusko.app;

import com.telusko.model.StudentInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.*;

public class LaunchSelective
{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfo.class).buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        byte image[] = null;
        FileReader fileReader = null;
        char textFile[] = null;
        FileInputStream file = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            file = new FileInputStream("C:\\Users\\User\\Downloads\\java.png");
            image = new byte[file.available()];
            file.read(image);

            File file1 = new File("C:\\Users\\User\\Downloads\\doc.txt");
            fileReader = new FileReader(file1);
            textFile = new char[(int)file1.length()];

            fileReader.read(textFile);


            StudentInfo studentInfo = new StudentInfo();

            studentInfo.setsName("Saranga");
            studentInfo.setScity("London");
            studentInfo.setImage(image);
            studentInfo.setTextFile(textFile);

            session.persist(studentInfo);
            flag = true;

        }catch (FileNotFoundException ex) {
          ex.printStackTrace();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (flag)
                transaction.commit();
            else

                transaction.rollback();
            try {
                fileReader.close();
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            sessionFactory.close();
            session.close();

        }
    }
}
