//Assignment: Automate the Add to Cart Functionality
//Scenario:
//Automate the "Add to Cart" functionality of an e-commerce website like https://www.saucedemo.com/.
//
//Steps:
//
//Launch the browser and navigate to the website.
//Log in using the provided credentials:
//Username: standard_user
//Password: secret_sauce
//Add the first two items displayed on the products page to the cart.
//Navigate to the cart page.
//Verify the names of the products in the cart match the ones added from the products page.
//Print the names and prices of the items in the cart to the console.
//Close the browser.
//Requirements:
//Use dynamic waits (e.g., WebDriverWait) for synchronization.
//Write assertions to verify:
//The products added to the cart appear correctly.
//The total count of products in the cart is correct.
//Modularize your code (e.g., separate methods for login, add to cart, verification).
//Hints for Locators:
//
//Use the id, class, or xpath attributes to locate elements. For example:
//Login fields: username, password
//Add to cart buttons: Look for buttons like //button[text()='Add to cart']
//Cart link: id="shopping_cart_container"
//Let me know if you need assistance with the implementation or troubleshooting! 😊




import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
