package lesson06;

import org.testng.annotations.DataProvider;

public class DataDrivenTestingBONUS {

    // ********** The calling is from DataDriverTesting.java > test02_BONUS method **********

    @DataProvider(name = "data")
    public static Object[][] getDataObject(){
        return new Object[][]{
                {"Israel", "Israel"},
                {"Automation", "Automation"},
                {"BlahBlah","Search results"}
        };
    }
}
