//Write a Script to open and close the browser based on user input

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasedOnUserInput {
	

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser Name:");
		String browser = sc.nextLine();
		WebDriver driver = null;
		if(browser.equals("Chrome")) {
		
		System.setProperty("webdriver.chromedriver.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		}
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.close();

	}

}
