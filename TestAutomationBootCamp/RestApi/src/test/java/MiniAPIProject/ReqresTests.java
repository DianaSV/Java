package MiniAPIProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//
public class ReqresTests extends CommonOps{
    @BeforeClass
    public void startSession(){
        setURL("https://reqres.in/");
        openChrome();
        navigateToURL();
        initAPI();
    }

    @Test
    public void TestingGetRequest(){
        expectedText = "Lindsay Ferguson";
        WorkFlow.getUserDataByID("api/users/", "8");
        Verifications.verifySting(actualText, expectedText);
    }

    @Test
    public void testSpecificGet(){
        WorkFlow.sendHttpRequest(url + "api/users?page=2");
        response.prettyPrint();
    }

    @Test
    public void testPOST(){
        WorkFlow.sendPOSTRequest(params,"api/users");
    }

    @AfterClass
    public void endSession(){
        closeDriver();
    }
}
