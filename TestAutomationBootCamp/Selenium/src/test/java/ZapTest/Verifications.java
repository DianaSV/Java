package ZapTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Verifications extends Operations{
    public static void verifyNoFlights(){
        Assert.assertTrue(zapPage.getNoResults().isDisplayed(), "There are available flights!");
    }

    public static void assertNoFlights(List<WebElement> list, String flightName){
        boolean flag = false;
        for(WebElement elem : list)
            if(elem.getText().equals(flightName)) {
                flag = true;
                break;
            }
        Assert.assertTrue(flag, "No such flight.");
    }

    public static void assertFlightIsBooked(){
        Assert.assertTrue(zapPage.getFlightIsBooked().isDisplayed(), "No alert, flight wasn't booked.");
    }
}
