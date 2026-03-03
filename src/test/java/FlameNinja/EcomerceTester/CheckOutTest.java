package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.Assert;

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
	
	public CheckOutPage GoToCheckOut() throws Exception{
		HomePage home = new HomePage(Setup());
		MensShirts men = home.GoToMensShirts();
		men.ChooseItem("Adult Android Superhero T-Shirt");
		ItemPage item = men.GoToItemPage();
		item.AddItemToCart();
		CartPage cart = item.GoToCartPage();
		CheckOutPage check = cart.GoToCheckout();
		return check;
	}
	
	public void ValidateEmail() throws Exception{
		String failEmail = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterEmail(failEmail);
		Assert.assertTrue(test);
	}
	public void ValidateName() throws Exception{
		String failName = "12";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterName(failName);
		Assert.assertTrue(test);
	}
	
	public void ValidateNumber() throws Exception{
		String failNumber = "abc";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterPhoneNumber(failNumber);
		Assert.assertTrue(test);
	}
	
	public void ValidateCCnum() throws Exception{
		String failCC = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCCNumber(failCC);
		Assert.assertTrue(test);
	}
	
	public void ValidateCity() throws Exception{
		String failCity = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCity(failCity);
		Assert.assertTrue(test);
	}
	
	public void ValidateCountry() throws Exception{
		String failState = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterState(failState);
		Assert.assertTrue(test);
	}
		
	public void ValidateAddress() throws Exception{
		String failAddress = "fail";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterAddress(failAddress);
		Assert.assertTrue(test);
	}
	
	public void ValidateZipCode() throws Exception{
		String failZipCode = "f";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterZip(failZipCode);
		Assert.assertTrue(test);
	}
	
	public void ValidateCVV() throws Exception{
		String failCVV = "a";
		CheckOutPage check = GoToCheckOut();
		Boolean test  = check.EnterCVV(failCVV);
		Assert.assertTrue(test);
	}
}
