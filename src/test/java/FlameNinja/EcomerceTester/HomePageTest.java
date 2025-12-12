package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class HomePageTest extends GenericTest{

	@Test
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
			}
		}
		assertTrue(true);
	}
	
}
