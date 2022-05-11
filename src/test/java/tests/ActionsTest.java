package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WaitsService waits = new WaitsService(driver, Duration.ofSeconds(10));
        List<WebElement>targetElements = waits.waitForAllVisibilityLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0),10,10)
                .pause(2000)
                .moveToElement(targetElements.get(1),10,10)
                .pause(2000)
                .moveToElement(targetElements.get(2),10,10)
                .pause(2000)
                .build()
                .perform();


        Thread.sleep(2000);
    }
    @Test
    public void fileUploadTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        WebElement fileUpload = driver.findElement(By.id("file-upload"));

    }
    @Test
    public void dynamicControlTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.waitForVisibilityLocatedBy(By.xpath("//input[@type='checkbox']"));
        WebElement button = wait.waitForVisibilityLocatedBy(By.xpath("//form/button[contains(text(), 'Remove')]"));
        button.click();
        Assert.assertTrue(wait.waitForElementInvisible(checkbox));
        WebElement input  = wait.waitForVisibilityLocatedBy(By.xpath("//form/input[@type='text']"));
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.xpath("//form/input[@disabled]")).isDisplayed());
        WebElement enabledButton = wait.waitForVisibilityLocatedBy(By.xpath("//form/button[contains(text(), 'Enable')]"));
        enabledButton.click();
        WebElement enabledText = wait.waitForVisibilityLocatedBy(By.xpath("//form/p[@id='message']"));
        Assert.assertTrue(wait.waitForVisibility(input).isEnabled());

    }
}
