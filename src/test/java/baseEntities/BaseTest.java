package baseEntities;

import Steps.AddMilestonesSteps;
import Steps.AddNewProjectSteps;
import Steps.LoginStep;
import Steps.NavigationSteps;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;

public class BaseTest {

    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationSteps navigationSteps;
    protected AddNewProjectSteps addNewProjectSteps;
    protected AddMilestonesSteps addMilestonesSteps;


    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        navigationSteps= new NavigationSteps(driver);
        addNewProjectSteps = new AddNewProjectSteps(driver);
        addMilestonesSteps = new AddMilestonesSteps(driver);
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
