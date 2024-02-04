package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import support.Constants;
import support.extentReportClass;

public class Assertions extends extentReportClass implements Constants {
	
	public void checkCurrentURLIsContain(String url) {
     	Assert.assertEquals(driver.getCurrentUrl(), url );
	}
	
	public void checkHeaderIsContain(String message) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText(),message);
	}
	
	public void checkPageTitleIsContain(String title) {
		Assert.assertEquals(driver.findElement(By.className("page-title")).getText(), title );
	    extentTest.log(Status.PASS, "Title contain correct value");
	}

	public void checkSelectIsContain(String selectOption) {
		Select select = new Select(driver.findElement(By.id("sorter")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
        Assert.assertEquals(defaultItem, selectOption);
	    extentTest.log(Status.PASS, "Select contain value");

	}
	
	public void checkOutputOfFilterIsSortedByAscendingOrder() {
		List<WebElement> products = driver.findElements(By.cssSelector(".item.product-item"));
	    char firstProductChar =  products.get(0).findElement(By.className("product-item-link")).getText().charAt(0);
	    char secondProductChar =  products.get(products.size()-1).findElement(By.className("product-item-link")).getText().charAt(0);
	    
	    if(firstProductChar == secondProductChar) {
            System.out.println("The first and second characters are equal, please check the fist 2 chars");
        	Assert.fail("Test failed because a specific condition is not met.");

	    }
	    else if(firstProductChar < secondProductChar){
            System.out.println("The first character is less than the second character.");
            Assert.assertTrue(firstProductChar < secondProductChar, "The first character is not less than the second character.");
	    }
	    else {
            System.out.println("The first character is greater than the second character.");
        	Assert.fail("Test failed because a specific condition is not met.");
	    }
	    
	}
	
}