package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Milestone Tests")
@Feature("Create Read Update Delete (CRUD)")
public class MilestonesTest extends BaseTest {
    @Test
    @Story("Create Milestone Test")
    @Step("Создание нового Milestone с заданными параметрами")
    @TmsLink("TR-001")
    @Description("Данный тест создает новый Milestone на сайте TestRail используя произвольные параметры описанные в самом тесте")
    @Severity(SeverityLevel.CRITICAL)
    public void addNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationSteps.navigateToAddNewMilestonesPage();
        Assert.assertEquals(addMilestonesSteps.addNewMilestone(ReadProperties.milestoneName(), "Some Text", "Some Text", "05/01/2022", "05/01/2022").getSuccessMessage().getText(), "Successfully added the new milestone.");
    }

    @Test(dependsOnMethods = "addNewMilestoneTest")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Read Milestone Test")
    @Step("Чтение созданного Milestone")
    @TmsLink("TR-002")
    public void readNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationSteps.navigateToMilestonesPage();
        Assert.assertEquals(addMilestonesSteps.readNewMilestoneStep().getMilestoneHeader().getText(), "NewMilestone");
    }

    @Test(dependsOnMethods = "readNewMilestoneTest")
    @Story("Update Milestone Test")
    @Step("Обновление данных в созданном Milestone")
    @TmsLink("TR-003")
    @Issue("TRB-1")
    @Severity(SeverityLevel.NORMAL)
    public void editNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationSteps.navigateToMilestonesPage().getNewMilestoneLinkText(ReadProperties.milestoneName()).click();
        Assert.assertEquals(addMilestonesSteps.editMilestoneStep().getMilestoneDescription().getText(), "Edited Text");

    }

    @Test(dependsOnMethods = "editNewMilestoneTest")
    @Story("Delete Milestone Test")
    @Step("Удаление созданного Milestone")
    @TmsLink("TR-004")
    @Link(name = "SomeName", url = "https://someurl.com")
    @Severity(SeverityLevel.NORMAL)
    public void deleteNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationSteps.navigateToMilestonesPage().getNewMilestoneLinkText(ReadProperties.milestoneName()).click();
        Assert.assertEquals(addMilestonesSteps.deleteMilestoneStep().getDeleteMessage().getText(), "Successfully deleted the milestone.");


    }
}
