package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestoneSidebarPage extends BasePage {
    private By sidebarStatusButton = By.xpath("//*[@id='navigation-milestones-status']");

    public MilestoneSidebarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return driver.findElement(sidebarStatusButton);
    }
}
