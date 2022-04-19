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
    @Test
    public void validateSKF()  {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        WebElement creatinin = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.cssSelector("input[type=button]"));
        WebElement mdrdResult = driver.findElement(By.id("txtMDRD"));
        WebElement hbpResult = driver.findElement(By.id("txtMDRD1"));
        WebElement cgResult = driver.findElement(By.id("txtCG"));
        WebElement bsaResult = driver.findElement(By.id("txtBSA"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);
        creatinin.sendKeys("80");
        age.sendKeys("38");
        weight.sendKeys("55");
        height.sendKeys("163");
        button.click();
        Assert.assertEquals(mdrdResult.getText(),"MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(hbpResult.getText(),"ХБП: 2 стадия (при наличии почечного повреждения)");
        Assert.assertEquals(cgResult.getText(),"Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(bsaResult.getText(),"Поверхность тела:1.58 (кв.м)");
    }
    @Test
    public void validateElectricFlourHeat() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement lenght = driver.findElement(By.id("el_f_lenght"));
        WebElement roomType = driver.findElement(By.id("room_type"));
        WebElement heatingType = driver.findElement(By.id("heating_type"));
        WebElement heatLosses = driver.findElement(By.id("el_f_losses"));
        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        WebElement button = driver.findElement(By.className("buttHFcalc"));
        Select selectRoomType = new Select(roomType);
        Select selectHeatingType = new Select(heatingType);
        width.sendKeys("3");
        lenght.sendKeys("5");
        selectRoomType.selectByValue("2");
        selectHeatingType.selectByValue("3");
        heatLosses.sendKeys("1000");
        button.click();
        floorCablePower.click();
        Assert.assertEquals(floorCablePower.getAttribute("value"), "557");
        specFloorCablePower.click();
        Assert.assertEquals(specFloorCablePower.getAttribute("value"), "37");
    }
        @Test
    public void validateCalculateLaminate() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement method = driver.findElement(By.id("laying_method_laminate"));
        Select layingMethodLaminate = new Select(method);
        WebElement direction = driver.findElement(By.id("direction-laminate-id1"));
        WebElement lnRoom = driver.findElement(By.id("ln_room_id"));
        WebElement wdRoom = driver.findElement(By.id("wd_room_id"));
        WebElement lnLam = driver.findElement(By.id("ln_lam_id"));
        WebElement wdLam = driver.findElement(By.id("wd_lam_id"));
        WebElement button = driver.findElement(By.className("calc-btn"));
        layingMethodLaminate.selectByValue("2");
        lnRoom.click();
        lnRoom.clear();
        lnRoom.sendKeys("500");
        wdRoom.click();
        wdRoom.clear();
        wdRoom.sendKeys("400");
        lnLam.click();
        lnLam.clear();
        lnLam.sendKeys("2000");
        wdLam.click();
        wdLam.clear();
        wdLam.sendKeys("200");
        direction.click();
        button.click();
        WebElement result = driver.findElement(By.cssSelector(".calc-result div:first-child span"));

        Assert.assertEquals(result.getAttribute("innerText"),"53");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
