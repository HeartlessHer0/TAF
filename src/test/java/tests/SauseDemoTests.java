package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SauseDemoTests {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void cssSelectorsTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("div input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("div input[type=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("div input.submit-button"));
        driver.findElement(By.cssSelector("div input#user-name")).clear();
        driver.findElement(By.cssSelector("div input[type=password]")).click();
        driver.findElement(By.cssSelector(".form_input[placeholder=Password]"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).click();
        driver.findElement(By.cssSelector("div input#password"));
        driver.findElement(By.cssSelector("div input#user-name")).sendKeys("locked_out_user");
        Thread.sleep(2000);

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div input[value=Login]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText() ,"Epic sadface: Sorry, this user has been locked out.");

    }
}
