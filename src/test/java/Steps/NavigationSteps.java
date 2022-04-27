package Steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;
import pages.SideMenuPage;

public class NavigationSteps extends BaseStep {
    public SideMenuPage sideMenuPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
        sideMenuPage = new SideMenuPage(driver);

    }
    public ProjectsPage navigateToProjectsPage(){
        projectsPage.openPageByUrl();
        return projectsPage;
    }
}
