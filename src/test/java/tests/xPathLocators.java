package tests;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class xPathLocators {
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
    public void basicXPathSelectors() {
        driver.get(ReadProperties.getUrl());
        //Абсолютный XPath (его использовать зашкварно)
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[5]/h1")).isDisplayed());
        // Аналог поиска по тегу
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        //Все элементы на странице, начиная с HTML
        driver.findElement(By.xpath("//*"));
        // Поиск родительского div и чайлда на один уровень ниже h1 (аналог + в css)
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());
        // Поиск родительского div и на любом уровне ниже div (аналог ~ в css)
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());
        // Поиск элемента с тегом div у готорого есть арибут с тегом id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());
        // Поиск элемента с тегом div у готорого есть арибут с тегом id со значением
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='top-logo']")).isDisplayed());
        // Поиск элемента c любым тэгом у которого есть атрибут id со значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top-logo']")).isDisplayed());
        // Поиск элемента c атрибутом @method='post' и атрибутом @target='_blank'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());
        // Поиск элемента/элементов c атрибутом @method='post' или атрибутом @target='_blank'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' or @target='_blank']")).isDisplayed());
        // Поиск элемента у которого значение атрибута id начинается с new
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());
        // Поиск элемента который содержит подстроку Template в атрибуте id
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id, 'Template')]")).isDisplayed());
        // Поиск элемента у которого текстовое значение сожержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Project')]")).isDisplayed());
        // Поиск элемента у которого текстовое значение сожержит равно, можно вместо text() вставить . (//div[.='All Project'])
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='All Project']")).isDisplayed());
        // Поиск элемента у которого текстовое значение сожержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Project')]")).isDisplayed());
        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div/a[3]")).isDisplayed());

    }
    @Test
    public void axesXPathTest(){
        driver.get(ReadProperties.getUrl());
        //Поиск непосредственного родителя у элемента c тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());
        //Поиск всех родителей до самого верха, то есть всех предков с тэгом div
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());
        //Поиск всех детей c тегом <a> у элемента с тэгом div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a[]")).isDisplayed());
        //Поиск элемента с тэгом form после элемента после элемента с атрибутом id='top'
        // То есть отрубается вся часть документа выше узла с атрибутом id='top' и ищутся наследникиэ
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']/following::form")).isDisplayed());
        // Противоположность following
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());
        // Как и с following, но выбираются узлы одного уровня (то есть только братьев и сестер)
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']/following-sibling::form")).isDisplayed());
        // Как и с preceding, но выбираются узлы одного уровня (то есть только братьев и сестер)
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top']/preceding-sibling::form")).isDisplayed());
    }
}

