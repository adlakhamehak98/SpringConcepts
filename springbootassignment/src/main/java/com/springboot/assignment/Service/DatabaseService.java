package com.springboot.assignment.Service;

import com.springboot.assignment.Entity.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    Database database;

    private final Logger LOG = LoggerFactory.getLogger(DatabaseService.class);

    public String getData() {
        LOG.info("getting database name and port from DatabaseService");
        return "Name: " + database.getName() + " Port: " + database.getPort();
    }
}
