package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import support.Constants;

public class Assertions implements Constants {
	
	public void checkCurrentURLIsContain(String url) {
     	Assert.assertEquals(driver.getCurrentUrl(), url );
	}
	
	public void checkHeaderIsContain(String message) {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText(),message);
	}
	
	public void checkPageTitleIsContain(String title) {
		Assert.assertEquals(driver.findElement(By.className("page-title")).getText(), title );
	}

	public void checkSelectIsContain(String selectOption) {
		Select select = new Select(driver.findElement(By.id("sorter")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
        Assert.assertEquals(defaultItem, selectOption);
	}
	
	
	
	// Assert.assertTrue(false);
	//	Assert.fail("Test failed because a specific condition is not met.");
	
}
