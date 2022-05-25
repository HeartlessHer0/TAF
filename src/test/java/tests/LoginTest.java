package tests;

import Steps.LoginStep;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import models.UserBuilder;
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
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        Assert.assertTrue(loginStep.successLogin(user).isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setEmail("asfasga");
        user.setPsw(ReadProperties.password());
        Assert.assertEquals(
                loginStep.incorrectLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }

    @Test
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw("asfasag");
        Assert.assertEquals(
                loginStep.incorrectLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
    }

    @Test
    public void successLoginBuilderTest() {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail("asdasd")
                .withPsw("afasfaf")
                .build();
    }
}
