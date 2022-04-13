package data;

import org.testng.annotations.DataProvider;

public class DataForDivInt {
    @DataProvider(name = "dataForDivInt")
    public static Object[][] dataForDivTest(){
        return new Object[][]{
                {-4,2,-2},
                {1,1,1},
                {0,1,0},
                {10,2,5},
                {-1,-1,-1}
        };
    }
}
