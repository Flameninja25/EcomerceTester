package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractClass {
	
	
	public static SearchContext shadow;
	
	public static SearchContext shadowPage;
	
	public static WebElement getItem(WebDriver driver, int i) throws InterruptedException {

		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector(" ul:nth-child(6) > li:nth-child("+i+") > a:nth-child(1) > shop-list-item:nth-child(1)")).getShadowRoot();
		Thread.sleep(1000);
		return shadow2.findElement(By.cssSelector(".title"));
	}
	
	public static HomePage GoToHomePage(WebDriver driver) {
		SearchContext shadow = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		shadow.findElement(By.cssSelector("a[aria-label='SHOP Home']")).click();
		return new HomePage(driver);
	}
	
}
