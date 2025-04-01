package com.pritam.student_management.model;

import jakarta.persistence.*;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generate ID
    private Long id;

    private String name;
    private int age;

    // Constructors
    public Student() {}

    public Student(Long id,String name, int age) {
        this.name = name;
        this.id=id;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
