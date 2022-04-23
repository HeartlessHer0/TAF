package tests;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_6 {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void smokeTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("div input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("div input[type=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("div input.submit-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).getText(),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(),"$15.99");
    }
    @Test
    public void relativeLocatorsSmokeTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("div input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("div input[type=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("div input.submit-button")).click();
        Thread.sleep(2000);
        WebElement tshirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        WebElement backpack = driver.findElement(with(By.tagName("button")).above(tshirt));
        WebElement bikeLight = driver.findElement(with(By.tagName("button")).toRightOf(backpack));
        WebElement tshirtRed = driver.findElement(with(By.tagName("button")).below(bikeLight).below(By.id("add-to-cart-sauce-labs-fleece-jacket")));
        tshirt.click();
        backpack.click();
        bikeLight.click();
        tshirtRed.click();
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(4000);

    }
}

