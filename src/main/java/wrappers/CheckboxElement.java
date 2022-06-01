package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxElement {
    private UIElement uiElement;
    private WebDriver driver;

    public CheckboxElement(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public CheckboxElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public void check() {
        if (uiElement.isSelected()) {
            return;
        }
        uiElement.click();
    }

    public void unCheck() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
        return;
    }
}
