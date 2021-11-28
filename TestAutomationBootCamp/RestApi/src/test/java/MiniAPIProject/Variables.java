package MiniAPIProject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variables {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String url;
    protected static String actualText, expectedText;

    protected static RequestSpecification request;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    protected static WebElement elem;
    protected static ReqresPage reqresPage;

    protected static String first_name;
    protected static String last_name;
    protected static String avatarURL;

}
