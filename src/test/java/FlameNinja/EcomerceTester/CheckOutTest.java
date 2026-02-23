package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckOutTest extends GenericTest{

	//check that the checkout item price matches
	public void CheckoutPrice() throws Exception {
    	String coat = "Adult Android Superhero T-Shirt";
    	String price ="$14.95";
    	HomePage home = new HomePage(Setup());
    	MensShirts men =  home.GoToMensShirts();
    	//men.tester();
    	men.ChooseItem(coat);
    	ItemPage item = men.GoToItemPage();
    	item.AddItemToCart();
    	CartPage cart = item.GoToCartPage();
    	CheckOutPage checkOut = cart.GoToCheckout();
    	assertTrue(checkOut.CheckItemPrice(coat, price));
    	CloseDriver();
	}
	
}
