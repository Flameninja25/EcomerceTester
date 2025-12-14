package FlameNinja.EcomerceTester;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractClass {
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CheckOutPage GoToCheckout() throws Exception {
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		Thread.sleep(500);
		shadow1.findElement(By.cssSelector("a[href='/checkout']")).click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}
	
	public boolean CheckItem(String itemName) throws Exception {
		//This Element is inside 3 nested shadow DOM.
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("shop-cart-item")).getShadowRoot();
		Thread.sleep(500);
		List<WebElement> items = shadow2.findElements(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a"));
		for(WebElement item : items){
			if(item.getText().contains(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public int CheckDifItemsInCart() {
		int numOfItems = 0;
		
		
		
		return numOfItems;
	}
	
	public WebDriver GetDriver() {
		return driver;
	}
}
