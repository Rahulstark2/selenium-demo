import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AutomateAddToCartFunctionality {
	WebDriver driver;
	private List<String> productNames;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	public void addToCart() throws InterruptedException {
		Thread.sleep(2000);
		
		List<WebElement> nameElements = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		
		
		productNames = new ArrayList<>();
	    for (WebElement element : nameElements) {
	        productNames.add(element.getText());
	    }
	    
	    
		List<WebElement> productsList = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
		for(int i = 0; i<2;i++) {
			productsList.get(i).click();
		}
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.saucedemo.com/cart.html");
	}
	
	public void verify() throws InterruptedException {
		Thread.sleep(2000);
		try {
		List<WebElement> productsName2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		
		List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		
		for(int i = 0; i<2; i++) {
			Assert.assertEquals(productNames.get(i), productsName2.get(i).getText());
			
			Assert.assertEquals(productNames.get(i), productsName2.get(i).getText());
            System.out.println("Product Name: " + productsName2.get(i).getText());

            // Validate prices
            String price = productsPrice.get(i).getText();
            Assert.assertFalse("Price is empty!", price.isEmpty());
            System.out.println("Price: " + price);
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			driver.quit();
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		AutomateAddToCartFunctionality obj = new AutomateAddToCartFunctionality();
		
		obj.launchBrowser();
		obj.login();
		obj.addToCart();
		obj.verify();
	}

}
