package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure Example")
@Feature("TestNG Support")

public class EpicTest {

    @Test
    @Story("Base Support Function 1")
    public void testName3(){
        Assert.assertTrue(true);
    }
}
