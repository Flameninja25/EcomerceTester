package FlameNinja.EcomerceTester;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MensClothesPage extends ClothesGeneralPage{
	
	WebDriver driver;
	
	//Constructor
	public MensClothesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//check this is the correct page by getting the page text
	public boolean CheckPage() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("h1")).getText();
		//Check this is Men's outerwear
		if(text.contains("Men's Outerwear")) {
			return true;
		}
		else {return false;}
	}
	
	//method to return to the home page
	public HomePage ReturnToHome() {
		return AbstractClass.GoToHomePage(driver);
	}
	
	//add an item to the cart depending on the name of the item
	public void ChooseItem(String cloth) throws Exception {
		//check al items and compare it to the wanted string
		for(int i = 1 ; i < GetNumberOfItems(driver) ; i++) {
			SearchContext test = GetItem(driver,i);
			String shadowText = test.findElement(By.cssSelector(".title")).getText().trim();
			if(shadowText.contains(cloth)) {
				test.findElement(By.cssSelector(".title")).click();
				break;
			}		
		}
	}
	
	//get price of an item from the name
	public String GetItemPrice(String itemName) throws Exception {
		for(int i = 1 ; i < GetNumberOfItems(driver) ; i++) {
			SearchContext test = GetItem(driver,i);
			//find item with the name and then get the price
			String shadowText = test.findElement(By.cssSelector(".title")).getText().trim();
			if(shadowText.contains(itemName)) {
				String itemPrice = test.findElement(By.cssSelector(".price")).getText();
				return itemPrice;
			}		
		}
		return "Invalid";
	}
	
	//go through every item and add them all to the cart
	public void AddAllItemsToCart() throws Exception{
		//AbstractClass.getShadowPage(driver);
		//SearchContext shadow = AbstractClass.shadowPage;
		for(int i = 1 ; i < GetNumberOfItems(driver) ; i++) {
			SearchContext test = GetItem(driver,i);
			test.findElement(By.cssSelector(".title")).click();
		}
	}
	
	public void GetNamesOfItems()
	{
		
	}
}
