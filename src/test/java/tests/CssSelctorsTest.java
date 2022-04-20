package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelctorsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get("E:\\AQA18\\TAF\\src\\test\\resources\\index.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("#helpIntro")).isDisplayed()); //# for ID
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());// .(dot) for class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed()); // Поиск по нескольким значения в аттрибуте class, важно чтобы не было пробела между атрибутами
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed()); // Поиск по тегу
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed()); // Совмещенный поиск tag div + class intro
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size()); // Совмещенный поиск c иерархией(используется пробел)
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size()); // Поиск всех элементов с тэгом h1 или p
        Assert.assertEquals(6,driver.findElements(By.cssSelector("div > p")).size()); // Поиск непосредственного наследников тега div с тэгом p
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size()); // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэгом ul
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size()); // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом p
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size()); // Поиск всех элементов c атрибутам title
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());// Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$=ess]")).size()); // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size()); // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value или value-
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id^=L]")).size()); // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size()); // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size()); // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());
        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());
        // Поиск всех выборанных элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());
        // Поиск всех элементов c пустым телом или без закрывающего тэга
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":empty")).size());


    }
}
