package MiniAPIProject;

import io.qameta.allure.Step;
import org.testng.Assert;

public class Verifications {
    @Step
    public static void verifySting(String actual, String expected){
        Assert.assertEquals(actual, expected, "Should be: " + expected + ", but it is: " + actual);
    }
}
