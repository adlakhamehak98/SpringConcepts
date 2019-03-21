package com.springAOPandEvents.events.entity;

//Question 3: Create a CustomEvent which should get published when you invoke connect method of database bean.

import com.springAOPandEvents.events.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.io.IOException;

public class Database implements ApplicationEventPublisherAware {
    String name;
    int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private ApplicationEventPublisher applicationEventPublisher;

    public void connect() {
        CustomEvent customEvent = new CustomEvent(this);
        applicationEventPublisher.publishEvent(customEvent);
        System.out.println("Connecting to Database {" +
                "name='" + name + '\'' +
                ", port=" + port +
                '}');
    }

    public  void  forQuestion6() throws IOException {
        throw new IOException();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
