package com.springboot.assignment.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//Create a Bean Database with two fields port and name and Access its values using application.properties (1 Mark)

@Component
public class Database {

    @Value("${app.name}")
    String name;

    @Value("${app.port}")
    String port;

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }
}
