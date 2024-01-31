package smokeTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;

public class searchFunctionality extends Actions {
	Actions action ; 
	String productName = "bag";
	String title = "Search results for: "+"'"+productName+"'";
	Assertions assertion ; 
	
	@BeforeTest
	public void initData() throws InterruptedException {
		
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(2000);
	}
	
	@Test(description = "search for item")
	public void searchItem() {

		action.typeInSearchInputField(productName);
		action.printPageTitle();
		assertion.checkPageTitleIsContain(title);
	}
	
	@AfterTest
	public void afterTest() {
		action.closeBrowser();
	}

}
