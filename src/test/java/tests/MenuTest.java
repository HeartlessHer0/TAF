package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {
    @Test
    public void validateDashboardMenuTest(){
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(),ReadProperties.password()).topMenuPage.isPageOpened());
    }
    @Test
    public void validateProjectsSideMenuTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        Assert.assertTrue(navigationSteps.navigateToProjectsPage().sideMenuPage.isPageOpened());
    }
}
