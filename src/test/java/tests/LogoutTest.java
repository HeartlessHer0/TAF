package tests;

import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.LoginPage;
@Epic("Login")
@Feature("Logout")
public class LogoutTest extends BaseTest{
    @Step("Logout Test")
    @Test(description = "Logout Test")
    public void logoutTest()  {
        new LoginPage().successLogin(ReadProperties.username(),ReadProperties.password()).logout().getButton().shouldBe(Condition.exist);
    }
}
