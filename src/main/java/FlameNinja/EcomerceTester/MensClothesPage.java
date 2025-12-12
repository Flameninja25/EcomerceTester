package FlameNinja.EcomerceTester;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MensClothesPage {
	
	WebDriver driver;
	
	public MensClothesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean CheckPage() throws Exception {
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='list']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-list[name='list']")).getShadowRoot();
		String text = shadow1.findElement(By.cssSelector("h1")).getText();
		if(text.contains("Men's Outerwear")) {
			return true;
		}
		else {return false;}
	}
	
	public HomePage ReturnToHome() {
		return AbstractClass.GoToHomePage(driver);
	}
	
	public void AddItemToCart(String cloth) throws Exception {
		//AbstractClass.getShadowPage(driver);
		//SearchContext shadow = AbstractClass.shadowPage;
		System.out.println("gaming");
		for(int i = 1 ; i < 16 ; i++) {
			WebElement test = AbstractClass.getItem(driver,i);
			String shadowText = test.getText().trim();
			System.out.println(shadowText);
			System.out.println(cloth);
			if(shadowText.contains(cloth)) {
				test.click();
				break;
			}
			
			
			
			
		}
;

	}
	
	public ItemPage GoToItemPage() {
		return new ItemPage(driver);
	}
	
	public void tester() {
		try {
			AbstractClass.getItem(driver,1).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
