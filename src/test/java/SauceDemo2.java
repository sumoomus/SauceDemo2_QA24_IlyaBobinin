import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemo2 {

    private static final String URL = "https://www.saucedemo.com";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }


    @Test
    public void positiveRegistrationTest() throws InterruptedException {

        WebElement loginInput = driver.findElement(By.cssSelector("#user-name"));
        loginInput.clear();
        loginInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement addToCardButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addToCardButton.click();

        WebElement shoppingCartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartButton.click();

        WebElement cartItemName = driver.findElement(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals("Sauce Labs Backpack", cartItemName.getText());

        WebElement cartItemPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals("$29.99", cartItemPrice.getText());


    }
}

