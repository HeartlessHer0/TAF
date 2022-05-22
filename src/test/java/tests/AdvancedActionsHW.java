package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class AdvancedActionsHW extends BaseTest {

    @Test
    public void jsAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        wait.waitForVisibilityLocatedBy(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        Assert.assertEquals(wait.waitForVisibilityLocatedBy(By.id("result")).getAttribute("innerText"), "You entered: Test");
    }

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));
        Assert.assertEquals(wait.waitForVisibilityLocatedBy(By.id("tinymce")).getText(), "Your content goes here.");
    }

    @Test
    public void contextClickTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        WebElement targetElement = wait.waitForVisibilityLocatedBy(By.id("hot-spot"));
        actions
                .contextClick(targetElement)
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void jsAlertGenerationTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) driver;
        jscriptExecutor.executeScript("alert('Some Alert');");
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Some Alert");
    }

    @Test
    public void jsNavigationTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) driver;
        jscriptExecutor.executeScript("window.location = 'http://the-internet.herokuapp.com/jqueryui/menu#'");
        Assert.assertEquals(String.valueOf(jscriptExecutor.executeScript("return document.URL;")), "http://the-internet.herokuapp.com/jqueryui/menu#");
    }

    @Test
    public void jsScrollTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/large");
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        jscriptExecutor.executeScript("window.scrollBy(0,4000)");
        Thread.sleep(5000);
    }

    @Test
    public void jsClickOnHiddenElementTest() {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) driver;
        WebElement hiddenElement = driver.findElement(By.id("ui-id-5"));
        jscriptExecutor.executeScript("arguments[0].click();", hiddenElement);
        Assert.assertEquals(String.valueOf(jscriptExecutor.executeScript("return document.URL;")), "http://the-internet.herokuapp.com/jqueryui");
    }


}
