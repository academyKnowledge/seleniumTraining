package smokeTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;

public class filterProductFunctionality extends Actions {
	
	Assertions assertion;
	Actions action ; 
	String productName = "Jackets";
	String option = "Product Name";
	
	@BeforeTest
	public void initData() throws InterruptedException {
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(2000);
	}
	
	@Test(description="filter functionality")
	public void filterProduct() {

		action.clickOnCategory();
		action.clickOnProductLink(productName);
		action.selectProductByItsIndex(1);
		assertion.checkSelectIsContain(option);
		
	}
	
	@AfterTest
	public void afterTest() {
		action.closeBrowser();
	}
}
