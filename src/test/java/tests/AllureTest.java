package tests;

import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure Example")
@Feature("TestNG Support")

public class AllureTest{


    @Test(description = "Main Test")
    public void testName(){
        Assert.assertTrue(true);
    }
    @Test
    @Description("Some Details For This Test")
    public void testName1(){
        Assert.assertTrue(true);
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testName2(){
        Assert.assertTrue(true);
    }
    @Test
    @Story("Base Support Function")
    public void testName3(){
        Assert.assertTrue(true);
    }
    @Test

    public void testName4(){
        step("Admin");
        Assert.assertTrue(true);
    }
    @Step("Username {user}")
    private void step(String user){
        System.out.println(user);
    }
    @Test
    @Issue("ID-123")

    public void testIssue(){
        Assert.assertTrue(true);
    }
    @Test
    @TmsLink("tc-532")

    public void testTms(){
        Assert.assertTrue(true);
    }
    @Test
    @Link("https://example.org")
    @Link(name = "allurelink",type = "myLink", url = "https://onliner.by")

    public void testLink(){
        Assert.assertTrue(true);
    }
    //Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES))); bad choise for screenshots
}
