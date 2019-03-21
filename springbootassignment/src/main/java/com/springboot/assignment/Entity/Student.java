package com.springboot.assignment.Entity;

//Create a Restful API using Spring Boot for Student.

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Integer rollNumber;
    private String name;
    private String classAndSection;

    public Student(Integer rollNumber, String name, String classAndSection) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.classAndSection = classAndSection;
    }

    public  Student(){};

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassAndSection() {
        return classAndSection;
    }

    public void setClassAndSection(String classAndSection) {
        this.classAndSection = classAndSection;
    }
}
