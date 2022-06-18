package tests;

import Steps.LoginStep;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(),ReadProperties.password()).isPageOpened());
    }
    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin(
                        "tgsegseg", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin(
                        ReadProperties.username(), "sfasf").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
    }
}
