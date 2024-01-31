package smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Actions;
import pageObjects.Assertions;

public class loginPage extends Actions {
	Actions action ; 
	Assertions assertion;
	String currentUrl ="https://magento.softwaretestingboard.com/";
	String message = "Welcome, cypress user!";
	@BeforeTest
	public void initData() throws InterruptedException {
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(2000);
	}
	
	@Test(description="login functionality")
	public void login() throws InterruptedException {
		action.clickOnSignInLink();
		action.typeInEmailInputField();
		action.typeInPasswordInputField();
		action.clickOnSignInButton();
		assertion.checkCurrentURLIsContain(currentUrl);
		Thread.sleep(3000);
		assertion.checkHeaderIsContain(message);
	}
	
	@AfterTest
	public void afterTest() {
		action.closeBrowser();
	}
}