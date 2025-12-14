package FlameNinja.EcomerceTester;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClothesGeneralPage {

	WebDriver driver;
	
	public ClothesGeneralPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int GetNumberOfItems(WebDriver driver) throws Exception  {
		int numItems = 0;
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("span")).getText();
		text = text.replaceAll("[\\(\\)]", "");
		text = text.trim();
		System.out.println(text);
		String[] halves = text.split("\\s+");
		text = halves[0].trim();
		System.out.println(text);
		numItems = Integer.parseInt(text);
		return numItems;
	}
	
	//static method to get the item by going through all the shadowdoms as all pages share same paths
	public WebElement GetItem(WebDriver driver, int i) throws InterruptedException {

		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector(" ul:nth-child(6) > li:nth-child("+i+") > a:nth-child(1) > shop-list-item:nth-child(1)")).getShadowRoot();
		Thread.sleep(500);
		return shadow2.findElement(By.cssSelector(".title"));
	}
	
	public String[] GetListOfItems() throws Exception {
		ArrayList<String> itemNames = new ArrayList<String>();
		for(int i = 1; i < GetNumberOfItems(driver); i++) {
			WebElement item = GetItem(driver, i);
			String text = item.getText();
			itemNames.add(text);
		}
		
		String[] lastArray = new String[itemNames.size()];
		itemNames.toArray(lastArray);
		return lastArray;
	}
	
}
