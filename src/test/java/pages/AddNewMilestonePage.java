package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/1";
    private By inputNameLocator = By.xpath("//*[@id='name']");
    private By inputReferenceLocator = By.xpath("//*[@id='reference']");
    private String dropdownParentLocator = "//ul//li[text()='Replace']";
    private By inputDescriptionLocator = By.xpath("//*[@id='description_display']");
    private By inputStartDateLocator = By.xpath("//*[@id='start_on']");
    private By inputEndDateLocator = By.xpath("//*[@id='due_on']");
    private By AddMilestoneButtonLocator = By.xpath("//*[@id='accept']");


    public AddNewMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return inputNameLocator;
    }
    public WebElement getInputName(){return waitsService.waitForPresenceOfElement(inputNameLocator);}
    public WebElement getInputReference(){return waitsService.waitForPresenceOfElement(inputReferenceLocator);}
    public WebElement getDropdownParent(String parentName){return waitsService.waitForPresenceOfElement(By.xpath(dropdownParentLocator.replace("Replace",parentName)));}
    public WebElement getInputDescription(){return waitsService.waitForPresenceOfElement(inputDescriptionLocator);}
    public WebElement getInputStartDate(){return waitsService.waitForPresenceOfElement(inputStartDateLocator);}
    public WebElement getInputEndDate(){return waitsService.waitForPresenceOfElement(inputEndDateLocator);}
    public WebElement getAddMilestoneButton(){return waitsService.waitForClickableElement(AddMilestoneButtonLocator);}

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
