package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class SuccessPage {

	WebDriver driver;
	
	public SuccessPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//click the last button to finish the order
	public void ClickFinish() throws Exception {
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-checkout[name='checkout']")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("a[href='/']"));
	}
}

