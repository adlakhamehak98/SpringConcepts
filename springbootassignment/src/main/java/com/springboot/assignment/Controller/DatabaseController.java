package com.springboot.assignment.Controller;

import com.springboot.assignment.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("/database")
    public String getData(){
        return databaseService.getData();
    }
}
