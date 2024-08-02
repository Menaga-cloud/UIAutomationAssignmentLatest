

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProductAddToCartTest {
    
    public static void main(String[] args) {
        // Set path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        
        try {
            // login to the product page
            driver.get("https://www.saucedemo.com/"); 
            WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
            userName.sendKeys("standard_user");
            
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.sendKeys("secret_sauce");
            WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
           login.click();                        
            
            // Verify product details
            WebElement productNameElement = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
            String productName = productNameElement.getText();         
 
            // assertions
            assert productName.equals("Sauce Labs Backpack");
               
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
            addToCartButton.click();

            
            // Verify product is added to cart successfully (assertion)
            WebElement cartIcon = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            assert cartIcon.getText().equals("1"); // verification for cart count
            
            System.out.println("Test passed: Product added to cart successfully.");
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            // Close the browser session
            driver.quit();
        }
    }
}
    