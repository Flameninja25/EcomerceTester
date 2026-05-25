package FlameNinja.EcomerceTester;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullTest extends GenericTest{

	public void AddallItemsToCart() throws Exception{
		
		//go to each page and add all items from each page to the cart
    	HomePage home = new HomePage(Setup());
    	MensClothesPage men =  home.GoToMensClothes();
    	String[] menOutItems = men.GetListOfItems();
    	for(String x :menOutItems) {
    		men.ChooseItem(x);
    		ItemPage itemPage = men.GoToItemPage();
    		itemPage.AddItemToCart();
    		Thread.sleep(500);
    		itemPage.StepBack();
    	}
    	
    	WomensClothesPage womenOut = men.GoToWomensOut();
    	String[] womenOutItems = womenOut.GetListOfItems();
    	for(String x :womenOutItems) {
    		womenOut.ChooseItem(x);
    		ItemPage itemPage = womenOut.GoToItemPage();
    		itemPage.AddItemToCart();
    		Thread.sleep(500);
    		itemPage.StepBack();
    	}
    	
    	MensShirts menShirts = womenOut.GoToMensShirts();
    	String[] menShirtItems = menShirts.GetListOfItems();
    	for(String x :menShirtItems) {
    		menShirts.ChooseItem(x);
    		ItemPage itemPage = menShirts.GoToItemPage();
    		itemPage.AddItemToCart();
    		Thread.sleep(500);
    		itemPage.StepBack();
    	}
    	
    	
    	WomensShirts womenShirts = menShirts.GoToWomensShirts();
    	String[] womenShirtItems = womenShirts.GetListOfItems();
    	for(String x :womenShirtItems) {
    		womenShirts.ChooseItem(x);
    		ItemPage itemPage = womenShirts.GoToItemPage();
    		itemPage.AddItemToCart();
    		Thread.sleep(500);
    		itemPage.StepBack();
    	}
    	
    	womenShirts.GoToCartPage();
    	
    	assertTrue(true);
    	CloseDriver();

	}
	
}
