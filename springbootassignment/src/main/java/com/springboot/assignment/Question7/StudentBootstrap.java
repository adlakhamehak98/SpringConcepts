package com.springboot.assignment.Question7;

import com.springboot.assignment.Entity.Student;
import com.springboot.assignment.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

//Bootstrap Data for Student Domain (3 Marks)
@Component
public class StudentBootstrap {
    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Iterator<Student> iterable = studentRepository.findAll().iterator();
        if (!iterable.hasNext()) {
            for (int i = 1; i <= 10; i++) {
                Student student = new Student(i, "Name "+i, "Class "+i);
                studentRepository.save(student);
            }
        }
        System.out.println("Your Application is up and running");
    }
}
