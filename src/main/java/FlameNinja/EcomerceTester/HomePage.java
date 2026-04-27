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
	
	//use button on the home page to go to mens outwear page
	public MensClothesPage FrontToMensClothes() {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(".iron-selected")).getShadowRoot();
		shadow1.findElement(By.cssSelector("a[aria-label=\"Men's Outerwear Shop Now\"]")).click();
		MensClothesPage mensClothes = new MensClothesPage(driver);
		return mensClothes;
	}
	
	//use button on the home page to go to womens outwear page
	public WomensClothesPage FrontToWomensClothes() {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(".iron-selected")).getShadowRoot();
		shadow1.findElement(By.cssSelector("a[aria-label='Ladies Outerwear Shop Now']")).click();
		WomensClothesPage womensClothes = new WomensClothesPage(driver);
		return womensClothes;
	}
	
	//use button on the home page to go to mens shirts page
	public MensShirts FrontToMensShirts() {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(".iron-selected")).getShadowRoot();
		shadow1.findElement(By.cssSelector("a[aria-label=\"Men's T-Shirts Shop Now\"]")).click();
		MensShirts mensShirts = new MensShirts(driver);
		return mensShirts;
	}
	
	//use button on the home page to go to womens shirts page
	public WomensShirts FrontToWomensShirts() {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(".iron-selected")).getShadowRoot();
		shadow1.findElement(By.cssSelector("a[aria-label='Ladies T-Shirts Shop Now']")).click();
		WomensShirts womensShirts = new WomensShirts(driver);
		return womensShirts;
	}
	
	
	//go to the cart
	public CartPage GoToCartPage() {
		driver.findElement(By.id("icon")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
