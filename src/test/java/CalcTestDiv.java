import data.DataForDivInt;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcTestDiv {
    protected Calculator calculator = new Calculator("Test calculator");

    @Test(enabled = false)
    public void integerCorrectDivisionTest() {
        Assert.assertEquals(calculator.divInt(3, 3), 1, "ERROR");
    }

    @Test(testName = "NegativeDivIntTest", description = "Деление на 0 интовых чисел", expectedExceptions = ArithmeticException.class)
    public void integerDivisionByZeroTest() {
        calculator.divInt(1, 0);
    }

    @Test(testName = "PositiveInfinity", description = "Деление на 0 дабл чисел", dependsOnMethods = "integerCorrectDivisionTest", groups = "DoubleDivZero")
    public void doublePositiveDivisionByZeroTest() {
        Assert.assertEquals(calculator.divDouble(3.1240, 0.000), Double.POSITIVE_INFINITY, "Infinity Error");
    }

    @Test(testName = "NegativeInfinity", groups = "DoubleDivZero", alwaysRun = true, priority = 2)
    public void doubleNegativeDivisionByZeroTest() {
        Assert.assertEquals(calculator.divDouble(-3.1240, 0.000), Double.NEGATIVE_INFINITY, "Infinity Error");
    }

    @Test(testName = "NaN", groups = "DoubleDivZero", timeOut = 50, invocationCount = 5,priority = 1)
    public void doubleDivisionZeroByZeroTest() {
        Assert.assertEquals(calculator.divDouble(0.000, 0.000), Double.NaN, "Infinity Error");
    }

    @Test(testName = "DataIntTest", dependsOnGroups = "DoubleDivZero", groups = "DataIntTest", dataProviderClass = DataForDivInt.class, dataProvider = "dataForDivInt", threadPoolSize = 5, alwaysRun = true)
    public void integerErrorDivisionTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.divInt(a, b), expectedResult, "Div Error");
    }

    // ToDo: Название тестовых методов - переделать согласно https://dzone.com/articles/7-popular-unit-test-naming
    //DONE
    // ToDo: Отсутствуют зависимые тесты
    //Вроде устанавливал значение dependsOnGroup и dependsOnMethod,  или это чтото другое?
    // ToDo: Отсутствуют приоритизированные тесты
    //Приорити тоже в двух тестах стояло
}


