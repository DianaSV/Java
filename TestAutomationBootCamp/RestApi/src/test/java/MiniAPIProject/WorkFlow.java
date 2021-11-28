package MiniAPIProject;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class WorkFlow extends CommonOps{
    @Step("Get users basic data and picture")
    public static void getUserDataByID(String path, String id){
        sendHttpRequest(path + id);
        extractDataFromHttpResponse();
    }

    @Step("Send GET Request")
    public static void sendHttpRequest(String query){
        APIActions.get(query);
    }

    @Step
    public static void sendPOSTRequest(JSONObject params, String resource){
        APIActions.post(params, resource);
    }

    @Step("Extract data and save actual text for test")
    private static void extractDataFromHttpResponse() {
        first_name = APIActions.extractFromJSON(response, "data.first_name");
        last_name = APIActions.extractFromJSON(response, "data.last_name");
        avatarURL = APIActions.extractFromJSON(response, "data.avatar");
        actualText = first_name + " " + last_name;
    }

    @Step("Navigate to avatar URL")
    private static void navigateToAvatarURL(){
        setURL(avatarURL);
        navigateToURL();
        wait.withMessage("Waiting for webpage to laod");
        //saveScreenshot(screenshotsPath, first_name + " " + last_name + " Avatar");
    }
}
