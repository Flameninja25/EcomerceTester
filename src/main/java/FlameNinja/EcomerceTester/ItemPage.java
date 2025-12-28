package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {

	WebDriver driver;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void AddItemToCart() throws Exception {
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='detail']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-detail[name='detail']")).getShadowRoot();
		Thread.sleep(500);
		shadow1.findElement(By.cssSelector("button[aria-label='Add this item to cart']")).click();
	}
	
	public CartPage GoToCartPage() throws Exception {
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='detail']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(".opened")).getShadowRoot();
		Thread.sleep(500);
		shadow1.findElement(By.cssSelector("#viewCartAnchor")).click();;
		return new CartPage(driver);	
	}
	
	public void StepBack() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='detail']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("paper-icon-button[aria-label='Go back']")).getShadowRoot();
		Thread.sleep(500);
		shadow1.findElement(By.cssSelector("#icon")).click();
	}
	
	public void SetAmount(int amount) throws Exception {
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='detail']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-detail[name='detail']")).getShadowRoot();
		Thread.sleep(1000);
		WebElement quanEle = shadow1.findElement(By.cssSelector("#quantitySelect"));
		Select selectQuan = new Select(quanEle);
		selectQuan.selectByIndex(amount-1);
		
		
		
	}
	
}
