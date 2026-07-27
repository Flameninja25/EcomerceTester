package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class WomansPageTest extends GenericTest{
	  	@Test
	  	//test to get an item and confirm it's in the cart
	    public void GetWomensCoat() throws Exception {
	    	String coat = "Ladies Colorblock Wind Jacket";
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women =  home.GoToWomensClothes();
	    	//men.tester();
	    	women.ChooseItem(coat);
	    	ItemPage item = women.GoToItemPage();
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	//cart.GoToCheckout();
	    	assertTrue(cart.CheckItem(coat));
	    	CloseDriver();
	    }
	    
	    @Test
	  	//a full test from selecting an item to the checkout
	    public void BuyWomensCoat() throws Exception {
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
	    	
	    	//list to store value
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
	    	
	    	//set the values
	    	String coat = "Ladies Colorblock Wind Jacket";
	    	//go through the pages adding the item to the cart and getting to checkout
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women =  home.GoToWomensClothes();
	    	women.ChooseItem(coat);
	    	ItemPage item = women.GoToItemPage();
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	CheckOutPage checkOut = cart.GoToCheckout();
	    	//add checkout detail using values above
	    	checkOut.AddDetails(values);
	    	SuccessPage finalPage = checkOut.ClickCheckOut();
	    	finalPage.ClickFinish();
	    	assertTrue(true);
	    	CloseDriver();
	    }
	    
	    @Test
	    //Add 2 specified items to the cart
	    public void AddTwoItemsToCart() throws Exception{
	    	//2 items to be added
	       	String coat = "Ladies Colorblock Wind Jacket";
	       	String coat2 = "Ladies Pullover L/S Hood";
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women =  home.GoToWomensClothes();
	    	//add both of the items to the cart
	    	women.ChooseItem(coat);
	    	ItemPage item = women.GoToItemPage();
	    	item.AddItemToCart();
	    	item.StepBack();
	    	women.ChooseItem(coat2);
	    	item.AddItemToCart();
	    	CartPage cart = item.GoToCartPage();
	    	//check both items are in the cart
	    	assertTrue(cart.CheckDifItemsInCart() == 2);
	    	CloseDriver();
	    }
	    
	    @Test
	    //add all the items on the page to the cart
	    public void AddAllItemsToCart() throws Exception {
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women =  home.GoToWomensClothes();
	    	//loop through all items on the page adding each one to the cart
	    	String[] items = women.GetListOfItems();
	    	for(String x :items) {
	    		women.ChooseItem(x);
	    		ItemPage itemPage = women.GoToItemPage();
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
	    	String coat = "Ladies Colorblock Wind Jacket";
	    	int quant = 4;
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women = home.GoToWomensClothes();
	    	women.ChooseItem(coat);
	    	//when on item page set the quantity to the set amount above
	    	ItemPage itemP = women.GoToItemPage();
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
	    public void AddItemOfSize() throws Exception{
	    	//set the basic variables
	    	String coat = "Ladies Colorblock Wind Jacket";
	    	String size = "L";
	    	//got to the mens page through the home page and add the correct item
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women = home.GoToWomensClothes();
	    	women.ChooseItem(coat);
	    	ItemPage itemP = women.GoToItemPage();
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
	    	String coat = "Ladies Colorblock Wind Jacket";
	    	String[] size = {"XS","S","M","L","XL"};
	    	//got to the mens page through the home page and add the correct item
	    	HomePage home = new HomePage(Setup());
	    	WomensClothesPage women = home.GoToWomensClothes();
	    	women.ChooseItem(coat);
	    	ItemPage itemP = women.GoToItemPage();
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
