package baseEntities;

import Steps.AddMilestonesSteps;
import Steps.AddNewProjectSteps;
import Steps.LoginStep;
import Steps.NavigationSteps;
import com.google.gson.Gson;
import configuration.ReadProperties;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import services.BrowsersService;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationSteps navigationSteps;
    protected AddNewProjectSteps addNewProjectSteps;
    protected AddMilestonesSteps addMilestonesSteps;
    protected Project mainProject;

    @BeforeTest
    public void prepareData() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("projectResult.json"));
        mainProject = new Gson().fromJson(reader, Project.class);
    }
    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        navigationSteps= new NavigationSteps(driver);
        addNewProjectSteps = new AddNewProjectSteps(driver);
        addMilestonesSteps = new AddMilestonesSteps(driver);
        //driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
