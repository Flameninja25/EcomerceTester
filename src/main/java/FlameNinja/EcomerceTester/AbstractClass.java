package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractClass {
	
	
	public static SearchContext shadow;
	
	public static SearchContext shadowPage;
	
	//create a new home class and click the home shop page
	public static HomePage GoToHomePage(WebDriver driver) {
		SearchContext shadow = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		shadow.findElement(By.cssSelector("a[aria-label='SHOP Home']")).click();
		return new HomePage(driver);
	}
	
}
