import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class test {
//	WebDriver driver = new ChromeDriver();
	WebDriver driver ;
	
	String email = "CypressUser@gmail.com";
	String password = "test@123";
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
        String currentDirectory = System.getProperty("user.dir");
        // Print the current working directory
        System.out.println("Current Directory: " + currentDirectory);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MSI\\eclipse-workspace\\QA-automation\\drivers\\chromedriver.exe");

//      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator+"drivers" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();

		// used to maximize the window
		driver.manage().window().maximize();
		// to visit the website you want
		driver.get("https://magento.softwaretestingboard.com/");
		// wait until the elements are shown in site
		Thread.sleep(1500);
	
	}

	@Test(enabled = true,priority = 0, description = "search for item")
	public void searchItem() {

		// sendKeys used to type in any field , Keys.ENTER to press enter 
		driver.findElement(By.id("search")).sendKeys("bag" + Keys.ENTER);
		WebElement element = driver.findElement(By.className("page-title"));
		System.out.println(element.getText());
	}

	@Test(enabled = false, priority = 1, description = "print category name")
	public void printCategoryName() {

		// find element by class name only you can use single class
		// if you want to use multiple classes use cssSelector
		List<WebElement> elements = driver.findElements(By.cssSelector(".level0.category-item"));

		// to access any element in array use get(index)
		System.out.println(elements.get(0));

		// to access all values we can use for loop

		// size() used to get the length of the list
		for (int i = 0; i < elements.size(); i++) {

			// getText() to get the text for any element
			System.out.println(elements.get(i).getText());
		}

	}
	
	@Test(enabled=false, priority = 2 , description="login functionality")
	public void login() {
    
//		driver.findElement(By.cssSelector(".authorization-link :first-child")).click();
		
		// find element by its text if the element was <a> .
//        driver.findElement(By.partialLinkText("Sign")).click();
		
		
      driver.findElement(By.linkText("Sign In")).click();
      driver.findElement(By.name("login[username]")).sendKeys(email);
      driver.findElement(By.name("login[password]")).sendKeys(password);
      driver.findElement(By.name("send")).click();

	}


	@Test( enabled=false , priority = 3 , description="filter functionality")
	public void filter() {

		// get element by id , don't use #
//	    driver.findElement(By.id("ui-id-2")).click();

		// find element using css selector , id # , class .
//		driver.findElement(By.cssSelector("#ui-id-2 > li:first-child > a >span")).click();

		// find element by its text if the element was <a> .
//		driver.findElement(By.linkText("What's New")).click();

		// find element using xpath
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]/span")).click();
		driver.findElement(By.linkText("Jackets")).click();
		
		 // Locate the dropdown element by its id 
        WebElement dropdownElement = driver.findElement(By.id("sorter"));

        // Create a Select object by passing the dropdown element
        Select dropdown = new Select(dropdownElement);
 
        // Select by visible text
//        dropdown.selectByVisibleText("Price");

        // Or, select by value attribute
//         dropdown.selectByValue("name");

        // Or, select by index (index starts from 0)
         dropdown.selectByIndex(0);

	}

	@AfterTest
	public void afterTest() {
		// to close the browser
		driver.close();
	}
}