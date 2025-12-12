package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MensShirts {
	WebDriver driver;
	
	public MensShirts(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean CheckPage() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("h1")).getText();
		if(text.contains("Men's T-Shirts")) {
			return true;
		}
		else {return false;}
	}
	
	public HomePage ReturnToHome() {
		return AbstractClass.GoToHomePage(driver);
	}
}
