package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.CheckboxElement;
import wrappers.DropdownElement;

public class WrappersTest extends BaseTest {
    @Test
    public void checkboxTest(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        CheckboxElement checkboxElement1 = new CheckboxElement(driver, By.xpath("//form/input[1]"));
        CheckboxElement checkboxElement2 = new CheckboxElement(driver, By.xpath("//form/input[2]"));
        checkboxElement1.check();
        Assert.assertTrue(checkboxElement1.isChecked());
        checkboxElement1.uncheck();
        Assert.assertEquals(checkboxElement1.isChecked(),false);

    }
    @Test
    public void dropdownTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        DropdownElement dropdownElement = new DropdownElement(driver, By.xpath("//select/option"));
        dropdownElement.selectByName("Option 1");
        Thread.sleep(3000);
        dropdownElement.selectByValue("2");
        Thread.sleep(3000);

    }
}
