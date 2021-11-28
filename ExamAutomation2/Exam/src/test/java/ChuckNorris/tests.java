package ChuckNorris;

import General.APIActions;
import General.AutomationListeners;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(AutomationListeners.class)
public class tests extends APIActions {
    @BeforeClass
    public void startSession(){
        url = "https://api.chucknorris.io/";
        RestAssured.baseURI = url;
        request = RestAssured.given();
    }

    @Test
    public void test01_jokesCategories(){
        APIActions.get(url + "jokes/categories");
        System.out.println("All joke ctegories: ");
        response.prettyPrint();
    }

    @Test
    public void test02_whoHadMoreSpotlight(){
        // Get jokes with Barak Obama
        APIActions.get(url + "jokes/search?query=Barack Obama");
        totalBarackObamaJokes = Integer.valueOf(APIActions.extractFromJSON(response, "total"));

        request = RestAssured.given();

        // Get jokes with Charlie Sheen
        APIActions.get(url + "jokes/search?query=Charlie Sheen");
        totalCharlieSheenJokes = Integer.valueOf(APIActions.extractFromJSON(response, "total"));

        // Check who has more jokes
        whoHasMoreJokes();
    }

    @Step
    public void whoHasMoreJokes() {
        if (totalBarackObamaJokes > totalCharlieSheenJokes)
            System.out.println("*** There are more Barack Obama jokes. ***");
        else if (totalBarackObamaJokes < totalCharlieSheenJokes)
            System.out.println(" *** There are more Charlie Sheen jokes. ***");
        else
            System.out.println("*** There are same amount of jokes of both Barak Obama and Charlie Sheen. ***");
    }
}
