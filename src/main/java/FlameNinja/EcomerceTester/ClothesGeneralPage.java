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
	public SearchContext GetItem(WebDriver driver, int i) throws InterruptedException {

		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		return shadow1.findElement(By.cssSelector(" ul:nth-child(6) > li:nth-child("+i+") > a:nth-child(1) > shop-list-item:nth-child(1)")).getShadowRoot();

	}
	
	//get a list of all the items on the current page
	public String[] GetListOfItems() throws Exception {
		ArrayList<String> itemNames = new ArrayList<String>();
		//add all the items to the list
		for(int i = 1; i < GetNumberOfItems(driver); i++) {
			SearchContext item = GetItem(driver, i);
			//save there title/name
			String text = item.findElement(By.cssSelector(".title")).getText();
			itemNames.add(text);
		}
		//convert the list to an array
		String[] lastArray = new String[itemNames.size()];
		itemNames.toArray(lastArray);
		return lastArray;
	}
	
	//go to the item page
	public ItemPage GoToItemPage() {
		return new ItemPage(driver);
	}
	
	public CartPage GoToCartPage() {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("paper-icon-button[aria-label='Shopping cart: 1 item']")).getShadowRoot();
		shadow1.findElement(By.cssSelector("#icon")).click();
		return new CartPage(driver);
	}
	
	//use links at top of page no matter the page the test is on
	public MensClothesPage GoToMensOut() {
		AbstractClass.shadow.findElement(By.linkText("Men's Outerwear")).click();	
		return new MensClothesPage(driver);
	}
	
	public MensShirts GoToMensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Men's T-Shirts")).click();	
		return new MensShirts(driver);
	}
	
	public WomensClothesPage GoToWomensOut() {
		AbstractClass.shadow.findElement(By.linkText("Ladies Outwear")).click();	
		return new WomensClothesPage(driver);
	}
	
	public WomensShirts GoToWomensShirts() {
		AbstractClass.shadow.findElement(By.linkText("Ladies T-Shirts")).click();	
		return new WomensShirts(driver);
	}
	
}
