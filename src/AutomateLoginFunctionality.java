//Assignment: Automate Login Functionality Using Selenium
//
//Create an automation script to test the login functionality of a website (e.g., a demo website like https://example.testproject.io/web/).
//The script should:
//Open the login page in a browser.
//Enter a valid username and password.
//Click the login button.
//Verify if the user successfully logs in by checking the presence of a logout button or welcome message.
//Close the browser.
//Use a testing framework like TestNG or JUnit for assertions.
//Make the script modular by separating the driver setup, login steps, and verification.
//Let me know if you need any clarifications or the solution! Good luck! 😊
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AutomateLoginFunctionality {
	
	WebDriver driver;
	
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	public void login() throws InterruptedException {
		try {
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		WebElement logoutElement = driver.findElement(By.xpath("//a[text()='Log out']"));
		Assert.assertEquals("Log out", logoutElement.getText());
		
		driver.quit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AutomateLoginFunctionality obj = new AutomateLoginFunctionality();
		obj.launchbrowser();
		obj.login();

	}

}
