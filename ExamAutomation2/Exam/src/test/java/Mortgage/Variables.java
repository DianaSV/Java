package Mortgage;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Variables {
    protected static RequestSpecification request;
    protected static Response response;
    protected static WebDriver driver;
    protected static JsonPath jp;

    protected static String url;
    protected static int totalBarackObamaJokes;
    protected static int totalCharlieSheenJokes;

    protected static MortgagePage mortgagePage;
    protected static Actions action;
}