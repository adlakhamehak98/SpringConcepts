package SpringCore.Question3to10except5;

//Question3to10except5:
//Create a class Restaurant.
// Create an interface HotDrink with an abstract method prepareHotDrink.
// Create two classes Tea and ExpressTea which implements HotDrink Class.
// Create an instance variable of type HotDrink in Restaurant class.
// Configure Tea and ExpressTea classes beans in Spring XML.
// create a bean with the name teaRestaurant of type Restaurant which inject Tea object as dependency using setter method.

public interface HotDrink {
    String prepareHotDrink();
}
