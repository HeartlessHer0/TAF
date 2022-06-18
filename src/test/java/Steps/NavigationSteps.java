package Steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

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
    public AddProjectPage navigateToAddNewProjectPage(){
        addProjectPage.openPageByUrl();
        return addProjectPage;
    }
    public MilestonesPage navigateToMilestonesPage(){
        milestonesPage.openPageByUrl();
        return milestonesPage;
    }
    public AddNewMilestonePage navigateToAddNewMilestonesPage(){
        addNewMilestonePage.openPageByUrl();
        return addNewMilestonePage;
    }

}
