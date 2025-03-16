//Write a script for the following:
// Open the browser
// Delete all cookies
// Set size of the window
// Set position of the window
// Maximize the window


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script {
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		Thread.sleep(2000);
		
		driver.manage().deleteAllCookies();
		
		Dimension d = new Dimension(500,500);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		
		Point p = new Point(250,250);
		driver.manage().window().setPosition(p);
		Thread.sleep(2000);
		
		driver.manage().window().maximize();

	}

}
