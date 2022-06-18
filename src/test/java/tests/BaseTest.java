package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        SelenideLogger.addListener("Selenide", new AllureSelenide());

    }
}
