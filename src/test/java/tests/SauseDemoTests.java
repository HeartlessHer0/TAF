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
        // driver.findElement(By.cssSelector("div input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("div > .form_input#user-name ")).sendKeys("standard_user");
        // driver.findElement(By.cssSelector("input[id|=user]")).sendKeys("standard_user");
        //driver.findElement(By.cssSelector(".input_error.form_input ")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("div input[type=password]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
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
    @Test
    public void xpathSelectorsTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        // driver.findElement(By.xpath("//div/input[@id='user-name']")).sendKeys("standard_user");
        // driver.findElement(By.xpath("//*[@class='input_error form_input error' and @id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//div//input[contains()]")).sendKeys("standard_user");
        // driver.findElement(By.xpath(".input_error.form_input ")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("div input.submit-button"));
        driver.findElement(By.xpath("div input#user-name")).clear();
        driver.findElement(By.xpath("div input[type=password]")).click();
        driver.findElement(By.xpath(".form_input[placeholder=Password]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("#password")).click();
        driver.findElement(By.xpath("div input#password"));
        driver.findElement(By.xpath("div input#user-name")).sendKeys("locked_out_user");
        Thread.sleep(2000);

        Thread.sleep(2000);
        driver.findElement(By.xpath("div input[value=Login]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText() ,"Epic sadface: Sorry, this user has been locked out.");

    }
}
