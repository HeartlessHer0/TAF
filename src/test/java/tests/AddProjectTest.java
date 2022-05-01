package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {
    @Test
    public void addNewProjectTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationSteps.navigateToAddNewProjectPage();
        Assert.assertEquals(addNewProjectSteps.addNewProject("New Project","Some Text").getSuccessMessage().getText(),"Successfully added the new project.");
    }
}
