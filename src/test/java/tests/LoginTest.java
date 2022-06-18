package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Epic("Login")

public class LoginTest extends BaseTest{


    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Step("Success Login Test")
    public void successLogin() {

        new LoginPage().successLogin(ReadProperties.username(),ReadProperties.password())
                .getNavigationMenu()
                .shouldBe(exist);


    }

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Step("Login With Incorrect Email")
    public  void inCorrectEmail(){

        new LoginPage().inCorrectLogin("qwerty",ReadProperties.password())
                .getIncorrectEmail()
                .shouldHave(text("Invalid email address"));
    }

    @Test(description = "enter incorrect password")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Login With Incorrect Password")
    public  void inCorrectPSW(){

        new LoginPage().inCorrectLogin(ReadProperties.username(),"12345")
                .getIncorrectPSW()
                .shouldHave(text("Your email or password is wrong"));
    }


}
