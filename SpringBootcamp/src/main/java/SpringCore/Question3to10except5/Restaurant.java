package SpringCore.Question3to10except5;

//Question3to10except5:
//Create a class Restaurant.
// Create an interface HotDrink with an abstract method prepareHotDrink.
// Create two classes Tea and ExpressTea which implements HotDrink Class.
// Create an instance variable of type HotDrink in Restaurant class.
// Configure Tea and ExpressTea classes beans in Spring XML.
// create a bean with the name teaRestaurant of type Restaurant which inject Tea object as dependency using setter method.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component("restaurantAnnotation")//q 10
public class Restaurant {

    //question 6: Autowire hotDrink in Restaurant with tea bean byName, byType and constructor.

    @Autowired//q 9
    private HotDrink hotDrink;

    public Restaurant() {
    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    @Required //question 8: Use @Required annotation for hotDrink setter method in Restaurant class.
    @Autowired//q 9
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Autowired//q 9
    public Restaurant(HotDrink hotDrink1) {
        this.hotDrink = hotDrink1;
    }

    @Override
    public String toString() {
        return "Restaurant{ " +
                "hotDrink=" + hotDrink.prepareHotDrink() +
                '}';
    }
}
