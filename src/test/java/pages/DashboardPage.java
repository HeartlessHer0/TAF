package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {


    //Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.className("content-header-title");

    public DashboardPage(WebDriver driver) {super(driver);}

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    //Блок атомарных методов
    public WebElement getHeaderTitleLabel(){return driver.findElement(headerTitleLabelLocator);}
}
