package com.springboot.assignment.Service;

import com.springboot.assignment.Entity.Student;
import com.springboot.assignment.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getStudentData() {
        logger.info("adding data in Student through StudentService");
        return Arrays.asList(
                new Student(1, "Mehak", "12 A"),
                new Student(4, "Sagar", "11 A"),
                new Student(45, "Shubham", "9 C"),
                new Student(25, "Gaurav", "11 D"),
                new Student(19, "Keshav", "10 B"),
                new Student(67, "Bhavna", "11 A")
        );
    }

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentDatabyBootstrap(){
        logger.info("getting bootstrapped data in Student from StudentService");
        List<Student> studentList = new ArrayList<>();
        Iterator<Student> studentIterator = studentRepository.findAll().iterator();
        studentIterator.forEachRemaining(studentList::add);
        return studentList;
    }
}
