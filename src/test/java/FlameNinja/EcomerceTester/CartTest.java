package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends GenericTest {
    @Test
    //check that the price in the cart is the same as the page price
    public void CheckItemPrice() throws Exception {
    	String coat = "Anvil L/S Crew Neck - Grey";
    	String priceWanted = "$22.15";
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
    	//men.tester();
    	men.ChooseItem(coat);
    	String pagePrice = men.GetItemPrice(coat);
    	if(!pagePrice.contains(pagePrice)) {Assert.assertTrue(false);}    	
    	ItemPage item = men.GoToItemPage();
    	item.AddItemToCart();
    	CartPage cart = item.GoToCartPage();
    	assertTrue(cart.ValidateItemPrice(coat, priceWanted));
    	CloseDriver();
    }
}
