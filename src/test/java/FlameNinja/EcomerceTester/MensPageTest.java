package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import FlameNinja.EcomerceTester.HomePage;
/**
 * Unit test for simple App.
 */
public class MensPageTest extends GenericTest{

    /**
     * Rigorous Test :-)
     */
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
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
    
    //@Test
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
    public void AddAllItemsToCart() throws Exception {
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
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
    
    @Test(groups= {"Single"})
    public void AddShirtOfSize() throws Exception{
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
    	if(cart.GetItemSize(size).contains(size)) {  		
    		assertTrue(true);
    	}
    	else {
    		assertTrue(false);
    	}
    	CloseDriver();
    }
    
    public void AddAllSizes() throws Exception {
    	
    }
    
    //@Test
    public void clicktest() {
    	HomePage home = new HomePage(Setup());
    	
		//home.RandomTest();
    	assertTrue(true);
    	
    }
}
