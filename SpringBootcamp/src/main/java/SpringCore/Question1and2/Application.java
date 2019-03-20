package SpringCore.Question1and2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //Question 2 : Get the bean of the class from spring container and print the values of the instance variable.
        Database database = applicationContext.getBean("database", Database.class);//name-id in xml file to prevent ambiguity
        System.out.println("Name- " + database.getName());
        System.out.println("Port Number- " + database.getPort());
    }
}
