package JSoup;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// https://drive.google.com/file/d/1owV0YRXS_WoWkbcGKWt0MY9_cfW-hAvy/view
public class GETResponseEx0102 {
    String city = "Jerusalem,IL";
    String key = "50f25ac7a285d4c391426452fcf6c043";
    String url = "http://api.openweathermap.org/data/2.5/weather";

    public static RequestSpecification httpRequest;
    public Response response;

    @BeforeClass
    public void startSession(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
    }

    @Test
    public void test01(){
        response = httpRequest.get("?units=metric&q=" + city + "&appid=" + key);
        JsonPath jp = response.jsonPath();
        response.prettyPrint();
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("Date"));
        Assert.assertTrue(response.contentType().contains("json"), "Not JSON");
        Assert.assertEquals(response.getStatusCode(), 200, "Not 200.");
    }
}
