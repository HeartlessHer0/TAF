package Steps.defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.When;

public class SecondStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("loginpage is opened")
    public void loginpageIsOpened() {
        baseCucumberTest.driver.get(ReadProperties.getUrl());
    }
}
