package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.Constants;
import support.extentReportClass;

public class Actions extends extentReportClass implements Constants {
	 
	
	public void maximizeBrowser(){
		driver.manage().window().maximize();
	}
	
	public void openLumaWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}    
	
	public void clickOnSignInLink() {
	    driver.findElement(By.linkText("Sign In")).click();
	}
	
	public void typeInEmailInputField() {
	    driver.findElement(By.name("login[username]")).sendKeys(email);
	}
	
	public void typeInPasswordInputField() {
	    driver.findElement(By.name("login[password]")).sendKeys(password);
	}
	
	public void clickOnSignInButton() {
	    driver.findElement(By.name("send")).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void typeInSearchInputField(String product) {
		driver.findElement(By.id("search")).sendKeys(product + Keys.ENTER);
	}
	
	public void printPageTitle() {
		WebElement element = driver.findElement(By.className("page-title"));
		System.out.println(element.getText());
	}
	
	public void clickOnCategory() {
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]/span")).click();
	}
	
	public void clickOnProductLink(String productName) {
		driver.findElement(By.linkText(productName)).click();
	}
	
	public void selectProductByItsIndex(int index){
        WebElement dropdownElement = driver.findElement(By.id("sorter"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
	}
}