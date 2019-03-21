package com.springAOPandEvents.events.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

//Question 2: Create listeners for spring events.
public class MyEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
    }
}
