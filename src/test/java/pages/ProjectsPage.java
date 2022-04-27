package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";
    private By headerTitleLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]");
    public SideMenuPage sideMenuPage;


    @Override
    protected By getPageIdentifier() {
        return headerTitleLocator;
    }

    public ProjectsPage(WebDriver driver) {
        super(driver);
        sideMenuPage = new SideMenuPage(driver);

    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
