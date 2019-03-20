package SpringCore.Question3to10except5;

//Question3to10except5:
//Create a class Restaurant.
// Create an interface HotDrink with an abstract method prepareHotDrink.
// Create two classes Tea and ExpressTea which implements HotDrink Class.
// Create an instance variable of type HotDrink in Restaurant class.
// Configure Tea and ExpressTea classes beans in Spring XML.
// create a bean with the name teaRestaurant of type Restaurant which inject Tea object as dependency using setter method.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        //Question 4: Get both the beans and invoke prepareHotDrink method via hotDrink instance variables.
        // Try inner bean with expressTeaRestaurant.
        Tea tea = applicationContext.getBean("tea", Tea.class);
        System.out.println(tea.prepareHotDrink());
        ExpressTea expressTea = applicationContext.getBean("expressTea", ExpressTea.class);
        System.out.println(expressTea.prepareHotDrink());
        Restaurant restaurant = (Restaurant) applicationContext.getBean("teaRestaurant");
        System.out.println(restaurant);
        Restaurant restaurant1 = (Restaurant) applicationContext.getBean("expressTeaRestaurant");
        System.out.println(restaurant1);
        System.out.println();

        //Question 6: Autowire hotDrink in Restaurant with tea bean byName, byType and constructor.
        // byConstructor
        Restaurant teaRestaurantByConstructor = (Restaurant) applicationContext.getBean("teaRestaurantByConstructor");
        System.out.println("Autowire byConstructor " + teaRestaurantByConstructor);
        //byName
        Restaurant expressTeaRestaurantByName = (Restaurant) applicationContext.getBean("expressTeaRestaurantByName");
        System.out.println("Autowire byName " + expressTeaRestaurantByName);


        //another xml file because byType throws an exception if more than one bean of same type is there.
        ApplicationContext applicationContextForTypeAutowiring =
                new ClassPathXmlApplicationContext("restaurant-autowire-type-config.xml");
        //byType
        Restaurant teaRestaurantByType =
                (Restaurant) applicationContextForTypeAutowiring.getBean("teaRestaurantByType");
        System.out.println("Autowire byType " + teaRestaurantByType);

        System.out.println();
        //Question 7: Set the scope of the teaRestaurant bean as proptotype and check the scope type after accessing the bean.
        Restaurant teaRestaurant = (Restaurant) applicationContext.getBean("teaRestaurant");
        System.out.println("Checking prototype scope as references equality gives : " + (restaurant == teaRestaurant));

        System.out.println();
        ApplicationContext applicationContextForAnnotation =
                new ClassPathXmlApplicationContext("restaurant-annotation-autowiring.xml");

        //Question 8: Use @Required annotation for hotDrink setter method in Restaurant class.
        //Question 9: Use @Autowired annotation to wire Tea with Restaurant class Using setter method, field and constructor.
        Restaurant teaRestaurantBySetterAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantBySetterAnnotation");
        System.out.println("Using Setter Autowire : " + teaRestaurantBySetterAnnotation);

        Restaurant teaRestaurantByFieldAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantByFieldAnnotation");
        System.out.println("Using Field Autowire : " + teaRestaurantByFieldAnnotation);

        Restaurant teaRestaurantByAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("teaRestaurantByAnnotation");
        System.out.println("Using Constructor Autowire : " + teaRestaurantByAnnotation);

        System.out.println();
        //Question 10: Use @Component, @Controller, @Repository etc annotation to configure Tea and Restaurant in Spring Container.
        Restaurant restaurantAnnotation =
                (Restaurant) applicationContextForAnnotation.getBean("restaurantAnnotation");
        System.out.println("Using Component Annotation : " + restaurantAnnotation);//autowire byField is by default
    }
}
