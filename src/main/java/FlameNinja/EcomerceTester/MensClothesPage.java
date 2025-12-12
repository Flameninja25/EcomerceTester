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
