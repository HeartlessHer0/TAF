package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void browserTest(){
        System.setProperty("webdriver.chrome.driver", "E:\\AQA18\\TAF\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
