package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomensClothesPage extends ClothesGeneralPage {
	WebDriver driver;
	
	//Constructor
	public WomensClothesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//check this is the correct page by getting the page text
	public boolean CheckPage() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("h1")).getText();
		//check the page is ladies outerwear
		if(text.contains("Ladies Outerwear")) {
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
		//AbstractClass.getShadowPage(driver);
		//SearchContext shadow = AbstractClass.shadowPage;
		for(int i = 1 ; i < GetNumberOfItems(driver) ; i++) {
			WebElement test = GetItem(driver,i);
			String shadowText = test.getText().trim();
			if(shadowText.contains(cloth)) {
				test.click();
				break;
			}		
		}
	}
	
	//go through every item and add them all to the cart
	public void AddAllItemsToCart() throws Exception{
		//AbstractClass.getShadowPage(driver);
		//SearchContext shadow = AbstractClass.shadowPage;
		for(int i = 1 ; i < GetNumberOfItems(driver) ; i++) {
			WebElement test = GetItem(driver,i);
			test.click();
		}
	}
	
	public void GetNamesOfItems()
	{
		
	}
}
