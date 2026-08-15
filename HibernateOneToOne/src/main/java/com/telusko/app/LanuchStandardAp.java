package com.telusko.app;

import com.telusko.model.Answer;
import com.telusko.model.Question;
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

        // Question - 1
        Answer answer = new Answer();
        answer.setId(1);
        answer.setAnswer("Hibernate is an ORM Framework");
        Question q1 = new Question(1, "What is Hibernate?", answer);

//        Question q2 = new Question(2, "What is Hibernate?", answer);

        Question question = session.get(Question.class, 1);
        System.out.println(question);
        try {
//            transaction = session.beginTransaction();
//            session.persist(answer);
//            session.persist(q1);
//            session.persist(q2);
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
