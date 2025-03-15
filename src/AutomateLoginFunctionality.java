import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AutomateLoginFunctionality {
	
	WebDriver driver;
	
	public void launchbrowser() {
		System.setProperty("webdriver,chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	public void login() throws InterruptedException {
		try {
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Passwod123");
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
