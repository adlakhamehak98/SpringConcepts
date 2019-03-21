package com.springAOPandEvents;

import com.springAOPandEvents.events.entity.Database;
import com.springAOPandEvents.events.Question1;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        //q1: Invoke context events start(), stop() and close().
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ctx.start();
        Question1 question1 = ctx.getBean("question1", Question1.class);
        question1.display();
        ctx.stop();
        //ctx.close(); //commented so that code after this is reachable

        //only refresh() can be called after close()

        //Question 3: Create a CustomEvent which should get published when you invoke connect method of database bean.
        Database database = ctx.getBean("database", Database.class);
        database.connect();
        database.forQuestion6();
    }
}
