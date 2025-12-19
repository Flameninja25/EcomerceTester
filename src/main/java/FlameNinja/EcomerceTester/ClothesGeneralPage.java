package FlameNinja.EcomerceTester;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClothesGeneralPage {

	WebDriver driver;
	
	//constructor
	public ClothesGeneralPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Get the number of items on the page
	public int GetNumberOfItems(WebDriver driver) throws Exception  {
		int numItems = 0;
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("span")).getText();
		//remove the brackets
		text = text.replaceAll("[\\(\\)]", "");
		text = text.trim();
		//split the text to get the 
		String[] halves = text.split("\\s+");
		text = halves[0].trim();
		numItems = Integer.parseInt(text);
		//return the number
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
	
	//get a list of all the items on the current page
	public String[] GetListOfItems() throws Exception {
		ArrayList<String> itemNames = new ArrayList<String>();
		//add all the items to the list
		for(int i = 1; i < GetNumberOfItems(driver); i++) {
			WebElement item = GetItem(driver, i);
			String text = item.getText();
			itemNames.add(text);
		}
		//convert the list to an array
		String[] lastArray = new String[itemNames.size()];
		itemNames.toArray(lastArray);
		return lastArray;
	}
	
}
