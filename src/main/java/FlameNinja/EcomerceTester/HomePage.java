package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public MensClothesPage GoToMensClothes() {
		AbstractClass.shadow.findElement(By.linkText("Men's Outerwear")).click();
		MensClothesPage mensClothes = new MensClothesPage(driver);
		return mensClothes;
	}
	
	public WomensClothesPage GoToWomensClothes() {
		AbstractClass.shadow.findElement(By.linkText("Ladies Outerwear")).click();
		WomensClothesPage womensClothes = new WomensClothesPage(driver);
		return womensClothes;
	}
	
	public MensShirts GoToMensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Men's T-Shirts")).click();
		MensShirts mensShirts = new MensShirts(driver);
		return mensShirts;
	}
	
	public WomensShirts GoToWomensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Ladies T-Shirts")).click();
		WomensShirts womenShirts = new WomensShirts(driver);
		return womenShirts;
	}
	
	public CartPage GoToCartPage() {
		driver.findElement(By.id("icon")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public CheckOutPage GoToCheckOutPage() {
		
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	public void RandomTest(){
		SearchContext shadow = driver.findElement(By.tagName("shop-app")).getShadowRoot();
		shadow.findElement(By.linkText("Men's Outerwear")).click();
	}
}
