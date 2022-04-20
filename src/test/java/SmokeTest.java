import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }
    @Test
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));
        WebElement result = driver.findElement(By.id("imt-result"));
        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();
        Thread.sleep(2000);
        Assert.assertEquals(result.getText(),"17.3 - Недостаточная (дефицит) масса тела");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
