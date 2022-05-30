package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {
    @Test
    public void addNewMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationSteps.navigateToAddNewMilestonesPage();
        Assert.assertEquals(addMilestonesSteps.addNewMilestone(ReadProperties.milestoneName(),"Some Text","Some Text","05/01/2022","05/01/2022").getSuccessMessage().getText(), "Successfully added the new milestone.");
    }
    @Test(dependsOnMethods = "addNewMilestoneTest")
    public void readNewMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationSteps.navigateToMilestonesPage();
        Assert.assertEquals(addMilestonesSteps.readNewMilestoneStep().getMilestoneHeader().getAttribute("innerText"), "NewMilestone" );
    }
    @Test(dependsOnMethods = "readNewMilestoneTest")
    public void editNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationSteps.navigateToMilestonesPage().getNewMilestoneLinkText(ReadProperties.milestoneName()).click();
        Assert.assertEquals(addMilestonesSteps.editMilestoneStep().getMilestoneDescription().getText(),"Edited Text");

    }
    @Test(dependsOnMethods = "editNewMilestoneTest")
    public void deleteNewMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationSteps.navigateToMilestonesPage().getNewMilestoneLinkText(ReadProperties.milestoneName()).click();
        Assert.assertEquals(addMilestonesSteps.deleteMilestoneStep().getDeleteMessage().getText(),"Successfully deleted the milestone.");


    }

    //Successfully deleted the milestone.
}
