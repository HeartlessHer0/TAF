package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditMilestonePage extends BasePage {
    private By attachmentListLocator = By.id("entityAttachmentListEmptyIcon");
    private By descriptionDisplayLocator = By.id("description_display");
    private By acceptButtonLocator = By.id("accept");
    private By deleteButtonLocator = By.xpath("//*[@class='button button-negative button-delete']");
    private By confirmDeleteCheckboxLocator = By.xpath("//span[@class='dialog-confirm-busy']/following-sibling::input[@name='deleteCheckbox']");
    private By confirmDeleteButtonLocator = By.xpath("//div[@id='deleteDialog']/div[@class='dialog-body']/following-sibling::div[@class='button-group dialog-buttons-highlighted']/a[contains(text(), 'OK')]");

    public EditMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return attachmentListLocator;
    }

    public WebElement getDescriptionDisplay(){return  driver.findElement(descriptionDisplayLocator);}
    public WebElement getAcceptButton(){return driver.findElement(acceptButtonLocator);}
    public WebElement getDeleteButton(){return driver.findElement(deleteButtonLocator);}
    public WebElement getConfirmDeleteCheckbox(){return driver.findElement(confirmDeleteCheckboxLocator);}
    public WebElement getConfirmDeleteButton(){return driver.findElement(confirmDeleteButtonLocator);}
}
