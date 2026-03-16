package FlameNinja.EcomerceTester;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	WebDriver driver;
	
	static SearchContext ShadowUse;
	
	public CheckOutPage(WebDriver driver) {

		this.driver = driver;
	}
	
	//click the check out button to go to the success page
	public SuccessPage  ClickCheckOut() throws Exception{
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-checkout[name='checkout']")).getShadowRoot();
		shadow1.findElement(By.cssSelector("input[value='Place Order']")).click();
		return new SuccessPage(driver);
	}
	
	//get the general shadow for the checkout page elements
	public void GetShadow() throws Exception {
		Thread.sleep(500);
		SearchContext shadow2 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		ShadowUse = shadow2.findElement(By.cssSelector("shop-checkout[class$='iron-selected']")).getShadowRoot();
		Thread.sleep(500);
	}
	
	//add all the details to the checkout using a list of strings
	public boolean AddDetails(List<String> info) throws Exception {
		Thread.sleep(1000);
		SearchContext shadow2 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadowMain = shadow2.findElement(By.cssSelector("shop-checkout[class$='iron-selected']")).getShadowRoot();
		Thread.sleep(500);
		if(!EnterEmail(info.get(0))){return false;}
		if(!EnterName(info.get(1))){return false;}
		if(!EnterPhoneNumber(info.get(2))){return false;}
		if(!EnterCCNumber(info.get(3))){return false;}
		if(!EnterAddress(info.get(4))){return false;}
		if(!EnterCity(info.get(5))){return false;}
		if(!EnterState(info.get(6))){return false;}
		if(!EnterZip(info.get(7))){return false;}
		if(!EnterCVV(info.get(8))){return false;}
		
		String[] date = info.get(9).split("\\s+");
		
		Select selectExp = new Select(shadowMain.findElement(By.cssSelector("#ccExpMonth")));
		selectExp.selectByIndex(Integer.parseInt(date[0]));
		
		Select selectExpMonth = new Select(shadowMain.findElement(By.cssSelector("#ccExpYear")));
		selectExpMonth.selectByVisibleText(date[1]);
		
		Select selectCountry = new Select(shadowMain.findElement(By.cssSelector("#shipCountry")));
		selectCountry.selectByVisibleText(info.get(10));
		return true;
	}
	
	public boolean CheckItemPrice(String itemName, String price) throws Exception {
		//get the item from the checkout list
		WebElement neededItem = null;
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-checkout[name='checkout']")).getShadowRoot();
		Thread.sleep(500);
		List<WebElement> items = shadow1.findElements(By.cssSelector(".row.order-summary-row"));
		//go through the list to search for the item
		for(WebElement x :items) {
			String name = x.findElement(By.cssSelector(".flex")).getText();
			if(name.contains(itemName)) {
				neededItem = x;
			}
		}
		//check if the item isn't null before checking the price
		if(neededItem != null) {
			WebElement itemPrice = neededItem.findElement(By.cssSelector("div:nth-child(2)"));
			return (price.contains(itemPrice.getText()));
		}
		return false;
	}
	
	//get the total price and compare it to a string price
	public boolean CheckTotalPrice(String price) throws Exception {
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-checkout[name='checkout']")).getShadowRoot();
		Thread.sleep(500);
		WebElement total = shadow1.findElement(By.cssSelector(".row.total-row"));
		String totalPrice = total.findElement(By.cssSelector("div:nth-child(2)")).getText();
		if(totalPrice.contains(price)) {
			return true;
		}
		return false;
	}
	
	//enter and check each of the fields
	public boolean EnterEmail(String email) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#accountEmail")).sendKeys(email);
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Email']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterName(String name) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#ccName")).sendKeys(name);
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Cardholder Name']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterPhoneNumber(String phoneNumber) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#accountNumber")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Phone Number']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterCCNumber(String ccNumber) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#ccNumber")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Email']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterAddress(String address) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#shipAddress")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Address']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterCity(String city) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#shipCity")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid City']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterState(String state) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#shipState")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid State/Province']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterZip(String zip) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#shipZip")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid Zip/Postal Code']")).size() > 0;
		return isPresent;
	}
	
	public boolean EnterCVV(String cvv) throws Exception {
		GetShadow();
		ShadowUse.findElement(By.cssSelector("#ccCVV")).sendKeys();
		boolean isPresent = ShadowUse.findElements(By.cssSelector("shop-md-decorator[error-message='Invalid CVV']")).size() > 0;
		return isPresent;
	}
	
	
}
