package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseStep {
    protected WebDriver driver;
    protected DashboardPage dashboardPage;
    protected LoginPage loginPage;

    public BaseStep(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

}
