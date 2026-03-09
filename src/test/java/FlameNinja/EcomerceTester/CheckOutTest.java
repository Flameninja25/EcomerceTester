package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends GenericTest{

	@Test
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
	
	 @Test(groups= {"Single"})
	public void OrderPrice() throws Exception{
		String coatOne = "Adult Android Superhero T-Shirt";
		String coatTwo = "Local Guides T-Shirt";
		String coatThree = "Basic Black T-Shirt";
    	HomePage home = new HomePage(Setup());
    	MensShirts men =  home.GoToMensShirts();
    	Float priceOne = Float.parseFloat(men.GetItemPrice(coatOne).replace("$", ""));
    	Float priceTwo = Float.parseFloat(men.GetItemPrice(coatTwo).replace("$", ""));
    	Float priceThree = Float.parseFloat(men.GetItemPrice(coatThree).replace("$", ""));
    	Float fullPrice = priceOne + priceTwo + priceThree;
    	men.ChooseItem(coatOne);
    	ItemPage item = men.GoToItemPage();
    	item.AddItemToCart();
    	item.StepBack();
    	men.ChooseItem(coatTwo);
    	item = men.GoToItemPage();
    	item.AddItemToCart();
    	item.StepBack();
    	men.ChooseItem(coatThree);
    	item = men.GoToItemPage();
    	item.AddItemToCart();
    	CartPage cart = item.GoToCartPage();
    	CheckOutPage checkOut = cart.GoToCheckout();
    	assertTrue(checkOut.CheckTotalPrice(Float.toString(fullPrice)));
    	CloseDriver();
    	
	}
	 
	 @Test
	public void ValidateEmail() throws Exception{
		String failEmail = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterEmail(failEmail);
		Assert.assertTrue(test);
		CloseDriver();
	}
	 
	@Test
	public void ValidateName() throws Exception{
		String failName = "12";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterName(failName);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateNumber() throws Exception{
		String failNumber = "abc";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterPhoneNumber(failNumber);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateCCnum() throws Exception{
		String failCC = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCCNumber(failCC);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateCity() throws Exception{
		String failCity = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCity(failCity);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateCountry() throws Exception{
		String failState = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterState(failState);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateAddress() throws Exception{
		String failAddress = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterAddress(failAddress);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateZipCode() throws Exception{
		String failZipCode = "f";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterZip(failZipCode);
		Assert.assertTrue(test);
		CloseDriver();
	}
	
	@Test
	public void ValidateCVV() throws Exception{
		String failCVV = "a";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCVV(failCVV);
		Assert.assertTrue(test);
		CloseDriver();
	}
}
