package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class WomensShirts extends ClothesGeneralPage{
	WebDriver driver;
	
	//Constructor
	public WomensShirts(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//check this is the correct page by getting the page text
	public boolean CheckPage() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("h1")).getText();
		//check the page is ladies t-shirts
		if(text.contains("Ladies T-Shirts")) {
			return true;
		}
		else {return false;}
	}
	
	//method to return to the home page
	public HomePage ReturnToHome() {
		return AbstractClass.GoToHomePage(driver);
	}
}
