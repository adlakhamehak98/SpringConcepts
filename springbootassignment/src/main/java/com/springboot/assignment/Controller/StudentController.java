package com.springboot.assignment.Controller;

import com.springboot.assignment.Entity.Student;
import com.springboot.assignment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudentData() {
        return studentService.getStudentData();
    }

    @GetMapping("/studentsBootstrap")
    public List<Student> getStudentDataByBootstrap() {
        return studentService.getStudentDatabyBootstrap();
    }
}
