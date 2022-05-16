package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatedMilestonePage extends BasePage {
    private By statusChartContainerLocator = By.xpath("//*[@id='statusChartContainer']");
    private By editButtonLocator = By.xpath("//*[contains(text(), 'Edit')]");
    private By milestoneDescriptionLocator = By.xpath("//div[@class='markdown']/p");
    private By milestoneHeaderLocator = By.xpath("//div[@class='content-header-title page_title']");
    public MilestoneSidebarPage milestoneSidebarPage;

    public CreatedMilestonePage(WebDriver driver) {
        super(driver);
        milestoneSidebarPage = new MilestoneSidebarPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return statusChartContainerLocator;
    }
    public WebElement getEditButton(){return driver.findElement(editButtonLocator);}
    public WebElement getMilestoneDescription(){return driver.findElement(milestoneDescriptionLocator);}
    public WebElement getMilestoneHeader(){return  driver.findElement(milestoneHeaderLocator);}

}
