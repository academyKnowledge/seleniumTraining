package smokeTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;

@Listeners
public class loginPage extends Actions {
	Actions action ; 
	Assertions assertion;
	String currentUrl ="https://magento.softwaretestingboard.com/";
	String message = "Welcome, cypress user!";
	
	@BeforeSuite
	public void initData() throws InterruptedException {
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(2000);
	}
	
	@Test(description="login functionality")
	public void login() throws InterruptedException {
		extentTest = extentReport.createTest("Login Functionality");
	    extentTest.log(Status.INFO, "login Test Start");
		action.clickOnSignInLink();
		action.typeInEmailInputField();
		action.typeInPasswordInputField();
		action.clickOnSignInButton();
		assertion.checkCurrentURLIsContain(currentUrl);
		Thread.sleep(3000);
		assertion.checkHeaderIsContain(message);
	}
	
	@AfterSuite
	public void afterTest() {
		action.closeBrowser();
	}
}