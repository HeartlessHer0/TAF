package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewProjectAddedPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";
    public NewProjectAddedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return successMessageLocator;
    }
    private By successMessageLocator = By.xpath("//*[@class='message message-success']");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getSuccessMessage(){return driver.findElement(successMessageLocator);}
}
