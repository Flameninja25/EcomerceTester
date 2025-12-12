package FlameNinja.EcomerceTester;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public SuccessPage  ClickCheckOut() throws Exception{
		SearchContext shadow0 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("shop-checkout[name='checkout']")).getShadowRoot();
		shadow1.findElement(By.cssSelector("input[value='Place Order']")).click();
		return new SuccessPage(driver);
	}
	
	public void AddDetails(List<String> info) throws Exception {
		Thread.sleep(1000);
		SearchContext shadow2 = driver.findElement(By.cssSelector("shop-app[page='checkout']")).getShadowRoot();
		Thread.sleep(500);
		SearchContext shadowMain = shadow2.findElement(By.cssSelector("shop-checkout[class$='iron-selected']")).getShadowRoot();
		Thread.sleep(500);
		shadowMain.findElement(By.cssSelector("#accountEmail")).sendKeys(info.get(0));;
		shadowMain.findElement(By.cssSelector("#ccName")).sendKeys(info.get(1));
		shadowMain.findElement(By.cssSelector("#accountPhone")).sendKeys(info.get(2));;
		shadowMain.findElement(By.cssSelector("#ccNumber")).sendKeys(info.get(3));
		shadowMain.findElement(By.cssSelector("#shipAddress")).sendKeys(info.get(4));
		shadowMain.findElement(By.cssSelector("#shipCity")).sendKeys(info.get(5));
		shadowMain.findElement(By.cssSelector("#shipState")).sendKeys(info.get(6));
		shadowMain.findElement(By.cssSelector("#shipZip")).sendKeys(info.get(7));
		shadowMain.findElement(By.cssSelector("#ccCVV")).sendKeys(info.get(8));
		
		String[] date = info.get(9).split("\\s+");
		
		Select selectExp = new Select(shadowMain.findElement(By.cssSelector("#ccExpMonth")));
		selectExp.selectByIndex(Integer.parseInt(date[0]));
		
		Select selectExpMonth = new Select(shadowMain.findElement(By.cssSelector("#ccExpYear")));
		selectExpMonth.selectByVisibleText(date[1]);
		
		Select selectCountry = new Select(shadowMain.findElement(By.cssSelector("#shipCountry")));
		selectCountry.selectByVisibleText(info.get(10));
	}
	
	
}
