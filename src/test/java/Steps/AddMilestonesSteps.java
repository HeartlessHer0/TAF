package Steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import pages.CreatedMilestonePage;
import pages.MilestonesPage;

public class AddMilestonesSteps extends BaseStep {

    public AddMilestonesSteps(WebDriver driver) {
        super(driver);
    }
    public MilestonesPage addNewMilestone(String name, String reference, String description, String start, String end){
        addNewMilestonePage.getInputName().sendKeys(name);
        addNewMilestonePage.getInputReference().sendKeys(reference);
        //addNewMilestonePage.getDropdownParent("233w");
        addNewMilestonePage.getInputDescription().sendKeys(description);
        addNewMilestonePage.getInputStartDate().sendKeys(start);
        addNewMilestonePage.getInputEndDate().sendKeys(end);
        addNewMilestonePage.getAddMilestoneButton().click();
        return milestonesPage;
    }
    public CreatedMilestonePage readNewMilestoneStep(){
        milestonesPage.getNewMilestoneLinkText(ReadProperties.milestoneName()).click();
        createdMilestonePage.getMilestoneHeader();
        createdMilestonePage.getMilestoneDescription();
        return createdMilestonePage;
    }
    public CreatedMilestonePage editMilestoneStep(){
        createdMilestonePage.getEditButton().click();
        editMilestonePage.getDescriptionDisplay().click();
        editMilestonePage.getDescriptionDisplay().clear();
        editMilestonePage.getDescriptionDisplay().sendKeys("Edited Text");
        editMilestonePage.getAcceptButton().click();
        return createdMilestonePage;
    }
    public MilestonesPage deleteMilestoneStep(){
        createdMilestonePage.getEditButton().click();
        editMilestonePage.getDeleteButton().click();
        editMilestonePage.getConfirmDeleteCheckbox().click();
        editMilestonePage.getConfirmDeleteButton().click();
        return milestonesPage;
    }
}
