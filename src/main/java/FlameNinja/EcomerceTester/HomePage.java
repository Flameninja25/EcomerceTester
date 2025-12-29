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
	
	//go to the mens outwear page
	public MensClothesPage GoToMensClothes() {
		AbstractClass.shadow.findElement(By.linkText("Men's Outerwear")).click();
		MensClothesPage mensClothes = new MensClothesPage(driver);
		return mensClothes;
	}
	
	//go to the womens outwear page
	public WomensClothesPage GoToWomensClothes() {
		AbstractClass.shadow.findElement(By.linkText("Ladies Outerwear")).click();
		WomensClothesPage womensClothes = new WomensClothesPage(driver);
		return womensClothes;
	}
	
	//go to the mens shirts page
	public MensShirts GoToMensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Men's T-Shirts")).click();
		MensShirts mensShirts = new MensShirts(driver);
		return mensShirts;
	}
	
	//go to the womens shirts page
	public WomensShirts GoToWomensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Ladies T-Shirts")).click();
		WomensShirts womenShirts = new WomensShirts(driver);
		return womenShirts;
	}
	
	//go to the cart
	public CartPage GoToCartPage() {
		driver.findElement(By.id("icon")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
