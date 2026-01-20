package FlameNinja.EcomerceTester;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends AbstractClass {
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//go to the checkout page from the cart page
	public CheckOutPage GoToCheckout() throws Exception {
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		Thread.sleep(500);
		shadow1.findElement(By.cssSelector("a[href='/checkout']")).click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}
	
	//check if an item is inside the cart
	public boolean CheckItem(String itemName) throws Exception {
		//This Element is inside 3 nested shadow DOM.
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("shop-cart-item")).getShadowRoot();
		Thread.sleep(500);
		List<WebElement> items = shadow2.findElements(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a"));
		//add all the text to the list
		for(WebElement item : items){
			if(item.getText().contains(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	//get the amount of an item in the cart based on an item name
	public int GetItemAmount(String itemName) throws Exception {
		//This Element is inside 3 nested shadow DOM.
		int count = 0;
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("shop-cart-item")).getShadowRoot();
		Thread.sleep(500);
		List<WebElement> items = shadow2.findElements(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a"));
		//check the item exists before looking for the wanted item
		if(!CheckItem(itemName)) return 0;
		//add all the text to the list
		for(WebElement item : items){
			if(item.getText().contains(itemName)) {
				break;
			}
			count++;
		}
		//get a list of all the quantity selects then use the index found above to get the correct item and then get the size that is selected for the clothing
		List<WebElement> itemSet = shadow2.findElements(By.cssSelector("#quantitySelect"));
		WebElement itemWant = itemSet.get(count);
		Select numSelect = new Select(itemWant);
		WebElement item = numSelect.getFirstSelectedOption();
		String numCon = item.getText();
		
		int newNum = Integer.parseInt(numCon);
		return newNum;
	}
	
	///method to get the item size of a wanted item
	public String GetItemSize(String itemName) throws Exception {
			//This Element is inside 3 nested shadow DOM.
			int count = 0;
			Thread.sleep(500);
			SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
			SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
			SearchContext shadow2 = shadow1.findElement(By.cssSelector("shop-cart-item")).getShadowRoot();
			Thread.sleep(500);
			List<WebElement> items = shadow2.findElements(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a"));
			if(!CheckItem(itemName)) return null;
			//add all the text to the list
			for(WebElement item : items){
				if(item.getText().contains(itemName)) {
					break;
				}
				count++;
			}
			List<WebElement> itemSet = shadow2.findElements(By.cssSelector(".size"));
			WebElement itemWant = itemSet.get(count);
			WebElement sizeWant = itemWant.findElement(By.cssSelector("span"));
			return sizeWant.getText();
	}
	
	public boolean CheckDifSizes(String itemName, String[] sizes) throws Exception {
		//Prepare the lists to be filled later in the code
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int count = 0;
		List<WebElement> items = new ArrayList<WebElement>();
		List<SearchContext> shadows = new ArrayList<SearchContext>(); 
		//get the shadows needed to access the shop items
		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("shop-cart-item")).getShadowRoot();
		//loops to get shadow roots for each item
		for(int k = 1;k < sizes.length+1;k++) {
			Thread.sleep(500);
			shadows.add(shadow1.findElement(By.cssSelector(" div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > shop-cart-item:nth-child("+k+")")).getShadowRoot());
		}
		//get each item
		for(SearchContext x : shadows) {
			items.add(x.findElement(By.cssSelector(" div:nth-child(3) > div:nth-child(1) > a:nth-child(1)")));
		}
		Thread.sleep(500);
		//make sure there is an itemname
		if(!CheckItem(itemName)) return false;
		//check if the item has the correct name and then add it to the list
		for(WebElement item : items){
			if(item.getText().contains(itemName)) {
				indexes.add(count);
			}
			count++;
		}
		ArrayList<Boolean> truths = new ArrayList<Boolean>();
		//list for the general items to get the there size later
		List<WebElement> itemSet = new ArrayList<WebElement>();
		for(SearchContext x : shadows) {
			itemSet.add(x.findElement(By.cssSelector(".size")));
		}
		//loop through all the items and sizes to make sure at least one of each size has been added to the cart
		for(int i = 0; i < indexes.size(); i++) {
			for(int j = 0; j < sizes.length; j++) {
				WebElement itemWant = itemSet.get(indexes.get(i));
				WebElement sizeWant = itemWant.findElement(By.cssSelector("span"));
				if(sizeWant.getText().equals(sizes[j])) {
					truths.add(true);
				}
			}
		} 
		//check that there is the correct amount of sizes before fully checking, only returning if they are all true
		if(truths.size() == sizes.length) {
			for(boolean x : truths) {
				if(x == false) {
					return false;
				}
			}
		}
		else{
			return false;
		}
		return true;
	}
	
	
	//check for each different item in the cart
	public int CheckDifItemsInCart() throws Exception {
		int numOfItems = 0;

		Thread.sleep(500);
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='cart']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-cart[name='cart']")).getShadowRoot();
		//List<WebElement> items = driver.findElements(By.cssSelector(".name"));
		List<WebElement> items = shadow1.findElements(By.cssSelector("shop-cart-item"));
		Thread.sleep(500);
		numOfItems = items.size();		
		return numOfItems;
	}
	
	public WebDriver GetDriver() {
		return driver;
	}
}
