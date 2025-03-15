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
