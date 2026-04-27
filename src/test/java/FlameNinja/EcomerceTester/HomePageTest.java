package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends GenericTest{

	@Test
	//go to each page using the top links
	public void HomeLinks() throws Exception {
		ArrayList<Boolean> pages = new ArrayList<Boolean>();
		HomePage homePage = new HomePage(Setup());
		MensClothesPage menClothes = homePage.GoToMensClothes();
		pages.add(menClothes.CheckPage());
		homePage = menClothes.ReturnToHome();
		
		WomensClothesPage womenClothes = homePage.GoToWomensClothes();
		pages.add(womenClothes.CheckPage());
		homePage = womenClothes.ReturnToHome();
		
		MensShirts menShirts = homePage.GoToMensShirts();
		pages.add(menShirts.CheckPage());
		homePage = menShirts.ReturnToHome();
		
		WomensShirts womenShirts = homePage.GoToWomensShirts();
		pages.add(womenShirts.CheckPage());
		homePage = womenShirts.ReturnToHome();
		
		for(Boolean x :pages) {
			if(!x) {
				assertTrue(false);
				CloseDriver();
			}
		}
		assertTrue(true);
		CloseDriver();
	}
	
	//test for the buttons on the home page
	@Test(groups= {"Single"})
	public void HomeButtons() throws Exception{
		ArrayList<Boolean> pages = new ArrayList<Boolean>();
		HomePage homePage = new HomePage(Setup());
		MensClothesPage menClothes = homePage.FrontToMensClothes();
		if(menClothes.CheckPage()) {homePage = menClothes.ReturnToHome();} else {Assert.assertTrue(false);}
		
		WomensClothesPage womenClothes = homePage.FrontToWomensClothes();
		if(womenClothes.CheckPage()) {homePage = womenClothes.ReturnToHome();} else {Assert.assertTrue(false);}
		
		MensShirts menShirts = homePage.FrontToMensShirts();
		if(menShirts.CheckPage()) {homePage = menShirts.ReturnToHome();} else {Assert.assertTrue(false);}
		
		WomensShirts womenShirts = homePage.FrontToWomensShirts();
		if(womenShirts.CheckPage()) {homePage = womenShirts.ReturnToHome();} else {Assert.assertTrue(false);}
		
		Assert.assertTrue(true);
		CloseDriver();
	}
	
}
