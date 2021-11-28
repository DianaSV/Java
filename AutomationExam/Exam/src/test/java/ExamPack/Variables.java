package ExamPack;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

public class Variables {
    protected static String baseURL = "http://localhost:8080/";
    protected static RequestSpecification request;
    protected static Response response;
    protected static WebDriver driver;
    protected static JsonPath jp;

    protected static Document doc; // for JSoup
}
