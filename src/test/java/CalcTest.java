import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {
    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(2,3),5,"Wrong sum");
    }
    @Test(enabled = false)
    public void testSum1(){
        Assert.assertEquals(calculator.sum(2,3),6,"Wrong sum");
    }
    @Test(description = "Тест с описанием")
    public void testSum2(){
        Assert.assertEquals(calculator.sum(2,3),5,"Wrong sum");
    }
    @Test(testName = "Test with Name")
    public void testSum3(){
        Assert.assertEquals(calculator.sum(2,3),5,"Wrong sum");
    }
    @Test(dataProvider = "dataForSum",dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int expectedResult){
        Assert.assertEquals(calculator.sum(a,b),expectedResult,"Wrong sum");
    }
    @Test(expectedExceptions = NullPointerException.class)
    public void testExeptions(){
       List list = null;
       int size = list.size();
    }

    @Test(invocationCount = 3,invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("go!"); ;
    }

    @Test (timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(1001);
    }
}

