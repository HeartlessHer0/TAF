package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import javax.security.auth.login.LoginContext;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setUpBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        // Configuration.assertionMode = AssertionMode.SOFT;
        // Configuration.clickViaJs = true;
        // Configuration.driverManagerEnabled = false;
        // Configuration.fastSetValue = false;
        // Configuration.headless = true;
        Configuration.reportsFolder = "target/screenshots";
        Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();
        Configuration.timeout = 20000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        /* or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

         */


    }

    @Test
    public void simpleSelenideTest() {
        open(ReadProperties.getUrl());
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

   /* @Test
    public void pageObjectSelenideTest() {
        open(ReadProperties.getUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.loginButton.click();
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }*/

    @Test
    public void selenideTestWithConfig() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        $(".page_title").shouldBe(visible).shouldHave(textCaseSensitive("all Projects"));
    }

    @Test
    public void multipleElementsSelenideTest() {
        open("/");


        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$("div.project") //$$ - для массива элементов
                .filter(visible)
                .shouldHave(size(26))
                .find(text("erg"))
                .click();
        $$("div.project")
                .first();//вернет первый элемент
        $$("div.project")
                .get(2);//вернет элемент по индексу
        sleep(3000); //аналог Thread.sleep
        refresh();// обновляет страницу
        title();//возвращает title страницы
        executeJavaScript(""); //jS executor
    }
    @Test
    public void SelenideTest() {
        open(ReadProperties.getUrl());
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
        System.out.println($(byText("asdasdasdfaszc")).innerText());
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        System.out.println($(byText("asdasdasdfaszc")).getValue());

        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr");//найти ближайший элемент
        $(byText("asdasdasdfaszc")).ancestor("div");
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent();
        $(byText("asdasdasdfaszc")).uploadFile((new File("")));
        //$(byText("asdasdasdfaszc")).download();

    }
    @Test
    public void SelenideTestAsserts() {
        open("/");
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();
        $("#anouncement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
        $("#anouncement")
                .should(exist).should(hidden).should(disabled)
                .shouldNotBe(visible).shouldBe(readonly)
                .shouldHave(name("fname")).shouldHave(value("John")).shouldHave(type("checkbox")).shouldBe(empty)
                .shouldBe(focused);
        WebElement webElement = $("#anouncement").toWebElement();

        Condition clickable = and("Can be clickable", visible,enabled);
        $$("#anouncement")
                .findBy(clickable).click();
        $("#anouncement").shouldBe(clickable);
        $("#anouncement")
                .shouldHave(text("Expected text"))
                .shouldHave(matchText("regex"))
                .shouldHave(exactText(" Exact Text "))
                .shouldHave(textCaseSensitive("expected Result Text"))
                .shouldHave(exactTextCaseSensitive("expected Result Text"));
    }

}

