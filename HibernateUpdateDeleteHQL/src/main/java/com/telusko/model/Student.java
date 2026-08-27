package com.telusko.model;

import jakarta.persistence.*;

@Entity
@Table(name = "studenttable")
public class Student {
    @Id
    private Integer sid;

    private String sname;

    private String scity;

    public Student() {
    }

    public Student(Integer sid, String sname, String scity) {
        this.sid = sid;
        this.sname = sname;
        this.scity = scity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scity='" + scity + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }
}
