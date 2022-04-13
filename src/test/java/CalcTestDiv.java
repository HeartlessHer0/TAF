import data.DataForDivInt;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcTestDiv {
    protected Calculator calculator = new Calculator("Test calculator");

    @Test(enabled = false)
    public void testDivInt() {
        Assert.assertEquals(calculator.divInt(3, 3), 1, "ERROR");
    }

    @Test(testName = "NegativeDivIntTest", description = "Деление на 0 интовых чисел", expectedExceptions = ArithmeticException.class)
    public void testDivInt2() {
        calculator.divInt(1, 0);
    }

    @Test(testName = "PositiveInfinity", description = "Деление на 0 дабл чисел", dependsOnMethods = "testDivInt2", groups = "DoubleDivZero")
    public void testDivDouble() {
        Assert.assertEquals(calculator.divDouble(3.1240, 0.000), Double.POSITIVE_INFINITY, "Infinity Error");
    }

    @Test(testName = "NegativeInfinity", groups = "DoubleDivZero", alwaysRun = true, priority = 2)
    public void testDivDouble1() {
        Assert.assertEquals(calculator.divDouble(-3.1240, 0.000), Double.NEGATIVE_INFINITY, "Infinity Error");
    }

    @Test(testName = "NaN", groups = "DoubleDivZero", timeOut = 50, invocationCount = 5,priority = 1)
    public void testDivDouble2() {
        Assert.assertEquals(calculator.divDouble(0.000, 0.000), Double.NaN, "Infinity Error");
    }

    @Test(testName = "DataIntTest", dependsOnGroups = "DoubleDivZero", groups = "DataIntTest", dataProviderClass = DataForDivInt.class, dataProvider = "dataForDivInt", threadPoolSize = 5, alwaysRun = true)
    public void testDivInt3(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.divInt(a, b), expectedResult, "Div Error");
    }

}


