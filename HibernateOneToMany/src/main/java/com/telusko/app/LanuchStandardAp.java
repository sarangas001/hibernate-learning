package com.telusko.app;

import com.telusko.model.Answer;
import com.telusko.model.Question;
import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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
        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion("What is Hibernate?");


//        Answer answer1 = new Answer();
//        answer1.setId(1);
//        answer1.setAnswer("Hibernate is an ORM Framework");
//        answer1.setQuestion(q1);
//
//
//        Answer answer2 = new Answer();
//        answer2.setId(2);
//        answer2.setAnswer("Hibernate is an implementation of JPA");
//        answer2.setQuestion(q1);
//
//        List<Answer> answers = new ArrayList<Answer>();
//        answers.add(answer1);
//        answers.add(answer2);
//
//        q1.setAnswers(answers);
//
//        Question question = session.get(Question.class, 1);
//        System.out.println(question);
        try {
//            transaction = session.beginTransaction();
//            session.persist(q1);
            Question question = session.get(Question.class, 1);
            System.out.println(question.getQuestion());
            question.getAnswers().forEach(System.out::println);
            flag = true;

        }catch (HibernateException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            if (flag) {
//                transaction.commit();
//            }else {
//                transaction.rollback();
//            }
            session.close();
            sessionFactory.close();
        }

    }
}
