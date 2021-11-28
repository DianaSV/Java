package ZapTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ZapTests extends Operations{

    @BeforeClass
    public void startSession() {
        setURL("http://demo.zaptest.com/login");
        setBrowser();
        initElems();
        navigateToURL();
    }

    @Test
    public void test01_login(){
        login("test", "demo");
    }

    @Test
    public void test02_flightNewYorkToLA2DaysAgo(){
        pickFlight("New York", "Los Angeles", "-", 2);
        isFlightNotFound();
    }

    @Test
    public void test03_flightNewYorkToLAIn2Days(){
        pickFlight("New York", "Los Angeles", "+", 2);
        lookForFlight("UA1029");
    }

    @Test
    public void test04_bookAndVerify(){
        bookFlightAndVerifyIsBooked("UA1029");
        Verifications.assertFlightIsBooked();
    }

    @Test
    public void test05_yourReservations(){
        isFlightReserved("UA1029");
    }

    @Test
    public void test06_cancelFlightAndVerify(){
        cancelFlight("UA1029");
        lookForFlight("UA1029");
    }
    @Test
    public void test07(){
        System.out.println();
    }
}
