package SpringCore.Question5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Complex-config.xml");
        Complex complex = applicationContext.getBean("complexBean", Complex.class);
        System.out.println(complex.list);
        System.out.println(complex.set);
        System.out.println(complex.map);
    }
}
