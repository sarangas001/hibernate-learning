package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetRecordApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;
        Session session2 = null;

        try {
            session = sessionFactory.openSession();
            session2 = sessionFactory.openSession();
            Student student = session.get(Student.class, 1);
            System.out.println(student);
            Student student2 = session2.get(Student.class, 1);
            System.out.println(student2);

            Student student3 = session.get(Student.class, 1);
            System.out.println(student3);


//            Student student = session.load(Student.class, 1);
//            Student student = session.getReference(Student.class, 44);
//            if(student!=null) {
//                System.out.println("ID is : " + student.getSid());
//                System.in.read();
//                System.out.println("Name is : " + student.getsName());
//                System.out.println("City is : " + student.getScity());
//            }else {
//                System.out.println("There is no data/record with id");
//            }

        }catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
            session2.close();
        }
    }
}
