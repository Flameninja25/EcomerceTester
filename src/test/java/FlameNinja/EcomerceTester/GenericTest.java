package FlameNinja.EcomerceTester;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericTest {
	
	static WebDriver drivermain;
	
	//method to setup driver
	public static WebDriver Setup() {
		//create driver
		WebDriver driver = new ChromeDriver();
		drivermain = driver;
		//set the driver to have a implicit wait (waits until page loads) and maximise the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//go to wanted website
		driver.get("https://shop.polymer-project.org/");
		AbstractClass.shadow = driver.findElement(By.tagName("shop-app")).getShadowRoot();;
		return driver;
	}
	
	public static void CheckOutButton() {
		
	}
	
	public static void CloseDriver() {
		drivermain.quit();
	}

	public static List<String> checkOutVals(){
		
		
		return null;
	}
	
	public static void IfAssertFails(boolean truth) {
		if(!truth) {
			assertTrue(false);
		}
		else {
			
		}
	}
}
