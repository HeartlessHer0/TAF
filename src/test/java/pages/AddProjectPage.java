package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    public TopMenuPage topMenuPage;

    public AddProjectPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameInputLocator;
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    private By nameInputLocator = By.xpath("//*[@id='name']");
    private By announcementInputLocator = By.xpath("//*[@id='announcement']");
    private By showTheAnnouncementCheckboxLocator = By.xpath("//*[@name='show_announcement']");
    private By addProjectButtonLocator = By.xpath("//*[@id='accept']");

    public WebElement getNameInput(){return driver.findElement(nameInputLocator);}
    public WebElement getAnnouncementInput(){return driver.findElement(announcementInputLocator);}
    public WebElement getShowTheAnnouncementCheckbox(){return driver.findElement(showTheAnnouncementCheckboxLocator);}
    public WebElement AddProjectButton(){return driver.findElement(addProjectButtonLocator);}
}

