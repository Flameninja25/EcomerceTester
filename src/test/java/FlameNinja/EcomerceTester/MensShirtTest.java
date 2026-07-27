package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class MensShirtTest extends GenericTest{
	  	@Test
	  	//test to get an item and confirm it's in the cart
	    public void GetMensShirt() throws Exception {
	    	String coat = "Adult Android Superhero T-Shirt";
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men =  home.GoToMensShirts();
	    	//men.tester();
	    	men.ChooseItem(coat);
	    	ItemPage item = men.GoToItemPage();
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	//cart.GoToCheckout();
	    	assertTrue(cart.CheckItem(coat));
	    	CloseDriver();
	    }
	    
	    @Test
	  	//a full test from selecting an item to the checkout
	    public void BuyMensShirt() throws Exception {
	    	String email = "Test@test.com";
	    	String cardName = "Jim Jones";
	    	String phoneNumber = "97643215642";
	    	String cardNumber = "2034010212341234";
	    	String address = "7828 Lafayette Avenue Brooklyn";
	    	String city = "New York";
	    	String state = "New York";
	    	String postCode = "NY 11230";
	    	String cvv = "223";
	    	String expireDate = "05 2026";
	    	String country = "United States";
	    	
	    	List<String> values = new ArrayList<>();
	    	values.add(email);
	    	values.add(cardName);
	    	values.add(phoneNumber);
	    	values.add(cardNumber);
	    	values.add(address);
	    	values.add(city);
	    	values.add(state);
	    	values.add(postCode);
	    	values.add(cvv);
	    	values.add(expireDate);
	    	values.add(country);
	    	
	    	
	    	
	    	String coat = "Adult Android Superhero T-Shirt";
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men =  home.GoToMensShirts();
	    	//men.tester();
	    	men.ChooseItem(coat);
	    	ItemPage item = men.GoToItemPage();
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	CheckOutPage checkOut = cart.GoToCheckout();
	    	checkOut.AddDetails(values);
	    	SuccessPage finalPage = checkOut.ClickCheckOut();
	    	finalPage.ClickFinish();
	    	assertTrue(true);
	    	CloseDriver();
	    }
	    
	    @Test
	    //Add 2 specified items to the cart
	    public void AddTwoItemsToCart() throws Exception{
	       	String coat = "Adult Android Superhero T-Shirt";
	       	String coat2 = "Basic Black T-Shirt";
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men =  home.GoToMensShirts();
	    	//men.tester();
	    	men.ChooseItem(coat);
	    	ItemPage item = men.GoToItemPage();
	    	item.AddItemToCart();
	    	item.StepBack();
	    	men.ChooseItem(coat2);
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	assertTrue(cart.CheckDifItemsInCart() == 2);
	    	CloseDriver();
	    }
	    
	    @Test
	    //add all the items on the page to the cart
	    public void AddAllItemsToCart() throws Exception {
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men =  home.GoToMensShirts();
	    	String[] items = men.GetListOfItems();
	    	for(String x :items) {
	    		men.ChooseItem(x);
	    		ItemPage itemPage = men.GoToItemPage();
	    		itemPage.AddItemToCart();
	    		Thread.sleep(500);
	    		itemPage.StepBack();
	    	}
	    	assertTrue(true);
	    	CloseDriver();
	    }
	    
	    @Test
	    //add multiple of one item
	    public void AddQuantOfSameItem() throws Exception {
	    	String coat = "Adult Android Superhero T-Shirt";
	    	int quant = 4;
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men = home.GoToMensShirts();
	    	//set the quantity of the item to the set amount
	    	men.ChooseItem(coat);
	    	ItemPage itemP = men.GoToItemPage();
	    	itemP.SetAmount(quant);
	    	itemP.AddItemToCart();
	    	CartPage cart = itemP.GoToCartPage();
	    	if(quant == cart.GetItemAmount(coat)) {  		
	    		assertTrue(true);
	    	}
	    	else {
	    		assertTrue(false);
	    	}
	    	CloseDriver();
	    	
	    }
	    
	    @Test//(groups= {"Single"})
	    //add an item of a specified size
	    public void AddShirtOfSize() throws Exception{
	    	//set the basic variables
	    	String coat = "Adult Android Superhero T-Shirt";
	    	String size = "L";
	    	//got to the mens page through the home page and add the correct item
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men = home.GoToMensShirts();
	    	men.ChooseItem(coat);
	    	ItemPage itemP = men.GoToItemPage();
	    	itemP.SetSize(size);
	    	itemP.AddItemToCart();
	    	CartPage cart = itemP.GoToCartPage();
	    	//check if the size is the same as the first set
	    	if(cart.GetItemSize(coat).contains(size)) {  		
	    		assertTrue(true);
	    	}
	    	else {
	    		assertTrue(false);
	    	}
	    	CloseDriver();
	    }
	    
	    @Test(groups= {"Single"})
	    public void AddAllSizes() throws Exception {
	    	//set the basic variables
	    	String coat = "Adult Android Superhero T-Shirt";
	    	String[] size = {"XS","S","M","L","XL"};
	    	//got to the mens page through the home page and add the correct item
	    	HomePage home = new HomePage(Setup());
	    	MensShirts men = home.GoToMensShirts();
	    	men.ChooseItem(coat);
	    	ItemPage itemP = men.GoToItemPage();
	    	//loop through each size and add them to the cart
	    	for(String x :size) {
	        	itemP.SetSize(x);
	        	itemP.AddItemToCart();
	    	}
	    	CartPage cart = itemP.GoToCartPage();
	    	//check if the size is the same as the first set  		
	    	if(cart.CheckDifSizes(coat, size)) { 			
	    		assertTrue(true);
	    	}
	    	else {
	    		assertTrue(false);
	    	}
	    	
	    	CloseDriver();
	    }
}
