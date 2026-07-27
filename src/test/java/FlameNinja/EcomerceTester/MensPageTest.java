package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import FlameNinja.EcomerceTester.HomePage;
/**
 * Unit test for simple App.
 */
public class MensPageTest extends GenericTest{

    
    @Test
    //test to get an item and confirm it's in the cart
    public void GetMensCoat() throws Exception {
    	String coat = "Anvil L/S Crew Neck - Grey";
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
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
    public void BuyMensCoat() throws Exception {
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
    	
    	//list to store values
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
    	
    	
    	
    	String coat = "Anvil L/S Crew Neck - Grey";
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
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
       	String coat = "Anvil L/S Crew Neck - Grey";
       	String coat2 = "Android Nylon Packable Jacket";
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
    	//men.tester();
    	men.ChooseItem(coat);
    	ItemPage item = men.GoToItemPage();
    	item.AddItemToCart();
    	item.StepBack();
    	men.ChooseItem("Android Nylon Packable Jacket");
    	item.AddItemToCart();
    	CartPage cart = item.GoToCartPage();
    	assertTrue(cart.CheckDifItemsInCart() == 2);
    	CloseDriver();
    }
    
    @Test
    //add all the items on the page to the cart
    public void AddAllItemsToCart() throws Exception {
    	//do the base setup
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
    	//get a list of all the items
    	String[] items = men.GetListOfItems();
    	//for each item in the list do a for loop to increment through them all
    	for(String x :items) {
    		men.ChooseItem(x);
    		//follow each item to the item page and select to add it to cart
    		ItemPage itemPage = men.GoToItemPage();
    		itemPage.AddItemToCart();
    		Thread.sleep(500);
    		//return to the original main page
    		itemPage.StepBack();
    	}
    	assertTrue(true);
    	CloseDriver();
    }
    
    @Test
  //add multiple of one item
    public void AddQuantOfSameItem() throws Exception {
    	String coat = "Anvil L/S Crew Neck - Grey";
    	int quant = 4;
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men = home.GoToMensClothes();
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
    public void AddItemOfSize() throws Exception{
    	//set the basic variables
    	String coat = "Anvil L/S Crew Neck - Grey";
    	String size = "L";
    	//got to the mens page through the home page and add the correct item
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men = home.GoToMensClothes();
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
    
    @Test//(groups= {"Single"})
    public void AddAllSizes() throws Exception {
    	//set the basic variables
    	String coat = "Anvil L/S Crew Neck - Grey";
    	String[] size = {"XS","S","M","L","XL"};
    	//got to the mens page through the home page and add the correct item
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men = home.GoToMensClothes();
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
    
    //@Test
    public void clicktest() {
    	HomePage home = new HomePage(Setup());
    	
		//home.RandomTest();
    	assertTrue(true);
    	CloseDriver();
    }
}
