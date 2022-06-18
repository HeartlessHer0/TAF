package Steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.NewProjectAddedPage;

public class AddNewProjectSteps extends BaseStep {

    public AddNewProjectSteps(WebDriver driver) {
        super(driver);
    }
    public NewProjectAddedPage addNewProject(String name, String announcement){
        addProjectPage.getNameInput().sendKeys(name);
        addProjectPage.getAnnouncementInput().sendKeys(announcement);
        addProjectPage.getShowTheAnnouncementCheckbox().click();
        addProjectPage.AddProjectButton().click();
        return newProjectAddedPage;
    }
}
