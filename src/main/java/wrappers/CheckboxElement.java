package wrappers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckboxElement {

    private UIElement uiElement;

    public CheckboxElement(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void toggle() {
        uiElement.click();
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    public boolean isChecked() {
        return uiElement.isSelected();
    }
}

