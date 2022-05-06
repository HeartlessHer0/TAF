package tests;

import baseEntities.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class waitsTest extends BaseTest {
    @Test
    public void presenceOfElementTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        wait.waitForVisibilityLocatedBy(By.xpath("//button")).click();
        Assert.assertTrue( wait.waitForVisibilityLocatedBy(By.id("loading")).isDisplayed());
        Assert.assertTrue( wait.waitForVisibilityLocatedBy(By.id("finish")).isDisplayed());
    }
    @Test
    public void presenceOfElementTest1(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        WebElement button = wait.waitForVisibilityLocatedBy(By.xpath("//button"));
        button.click();
        Assert.assertTrue(wait.waitForElementInvisible(button));
        WebElement loading  = wait.waitForVisibilityLocatedBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(wait.waitForElementInvisible(loading));

        Assert.assertTrue( wait.waitForVisibilityLocatedBy(By.id("finish")).isDisplayed());
    }
}
