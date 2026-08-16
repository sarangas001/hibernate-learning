package com.telusko.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
public class Question {
    @Id
    private Integer id;
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    private  List<Answer> answers;

    public Question() {
    }

    public Question(Integer id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
