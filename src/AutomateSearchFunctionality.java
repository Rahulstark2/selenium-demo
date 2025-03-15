//Assignment: Automate Search Functionality on an E-Commerce Website
//
//Open an e-commerce website like https://www.amazon.in or a demo website like http://automationpractice.com/index.php.
//Automate the following steps:
//Launch the browser and navigate to the website.
//Locate the search bar and enter a product name (e.g., "shirt").
//Click the search button.
//Verify if the search results contain the product name in the titles or descriptions.
//Print the names of the first five search results in the console.
//Close the browser after the test.
//Requirements:
//
//Use Selenium WebDriver to interact with the website.
//Use assertions (e.g., JUnit or TestNG) to verify the search results.
//Write modular code for better readability and maintenance.




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.junit.Assert;

public class AutomateSearchFunctionality {
	WebDriver driver;
	
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
	
	public void search() throws InterruptedException {
		try {
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirt");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void verify() throws InterruptedException {
		try {
		Thread.sleep(2000);
		WebElement resultElement = driver.findElement(By.xpath("//h2[text()='Results']"));
		Assert.assertEquals("Results", resultElement.getText());
		
		List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']//span"));
		
		System.out.println("Checking product titles for the keyword 'shirt':");
		
		for (int i = 0; i < productTitles.size(); i++) {
            String title = productTitles.get(i).getText();
            if (i < 5) { 
                System.out.println((i + 1) + ". " + title);
            }

            if (title.toLowerCase().contains("shirt")) {
                System.out.println("The title contains 'shirt': " + title);
            }
		}
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		AutomateSearchFunctionality obj = new AutomateSearchFunctionality();
		obj.launchbrowser();
		obj.search();
		obj.verify();
	}

}
