package com.telusko.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Students {
    @Id
    @Column(name = "student_id")
    private Integer id;

    private String name;

    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Courses> courses;

    public Students() {
        System.out.println("Zero Param Constructor of students");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", courses=" + courses +
                '}';
    }
}
