import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com/");
		
		driver.navigate().to("https://www.facebook.com/");
		
		Thread.sleep(1000);
		
		driver.navigate().back();
		
		Thread.sleep(1000);
		
		driver.navigate().forward();
		
		Thread.sleep(1000);
		
		driver.navigate().refresh();

	}

}
