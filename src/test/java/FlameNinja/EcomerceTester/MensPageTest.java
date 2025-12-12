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
    
    //@Test
    public void GetMensCoat() throws Exception {
    	String coat = "Anvil L/S Crew Neck - Grey";
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
    	//men.tester();
    	men.AddItemToCart(coat);
    	ItemPage item = men.GoToItemPage();
    	item.AddItemToCart();
    	CartPage cart = item.GoToCartPage();
    	//cart.GoToCheckout();
    	assertTrue(cart.CheckItem(coat));
    	CloseDriver();
    }
    
    @Test
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
    	men.AddItemToCart(coat);
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
    
    public void GetWomensCoat() {
    	HomePage home = new HomePage(Setup());
    	home.GoToWomensClothes();
    }
    
    //@Test
    public void clicktest() {
    	HomePage home = new HomePage(Setup());
    	
		//home.RandomTest();
    	assertTrue(true);
    	
    }
}
