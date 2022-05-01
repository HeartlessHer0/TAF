package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/1";
    private By addMilestoneButtonLocator = By.xpath("//*[@id='navigation-milestones-add']");
    private By successMessageLocator = By.xpath("//*[contains(text(), 'Successfully added the new milestone.')]");
    private String newMilestoneLinkLocator = "//div/a[contains(text(), 'Replace')]";
    private By deleteMessageLocator = By.xpath("//*[contains(text(), 'Successfully deleted the milestone.')]");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return addMilestoneButtonLocator;
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getSuccessMessage(){return driver.findElement(successMessageLocator);}
    public WebElement getNewMilestoneLinkText(String milestoneLinkText){return driver.findElement(By.xpath(newMilestoneLinkLocator.replace("Replace",milestoneLinkText)));}
    public WebElement getDeleteMessage(){return  driver.findElement(deleteMessageLocator);}
}

