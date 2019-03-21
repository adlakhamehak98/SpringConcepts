package com.springAOPandEvents.events.listener;

import com.springAOPandEvents.events.CustomEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.getSource());
    }
}
