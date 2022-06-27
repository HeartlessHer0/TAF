package Steps.defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;

public class MainStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public MainStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("chrome is started")
    public void chromeIsStarted() {
        baseCucumberTest.driver.get("http://onliner.by");
    }
}
