package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
}
