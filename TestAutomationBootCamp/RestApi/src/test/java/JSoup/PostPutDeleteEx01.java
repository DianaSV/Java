package JSoup;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostPutDeleteEx01 {
    String baseURL = "http://localhost:8080";
    public static RequestSpecification request;
    public static Response response;

    @BeforeClass
    public void startSession(){
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Test
    public void test01_NEW(){
        JSONObject params = new JSONObject();
        params.put("firstName", "Diana");
        params.put("lastName", "Choub");
        params.put("email", "diana@gmail.com");
        params.put("programme", "QA");

        request.body(params.toJSONString());
        response = request.post("/student");

        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void test02_NEWWithCourse(){
        JSONObject params = new JSONObject();
        params.put("firstName", "Kuku");
        params.put("lastName", "Kaka");
        params.put("email", "kuku@gmail.com");
        params.put("programme", "kiki");

        JSONArray arr = new JSONArray();
        arr.add("Python Course");
        arr.add("CSharp Course");
        arr.add("Java Course");
        params.put("courses", arr);

        request.body(params.toJSONString());
        response = request.post("/student");

        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void test03_EDIT(){
        JSONObject params = new JSONObject();
        params.put("firstName", "Diana");
        params.put("lastName", "Choubaev");
        params.put("email", "diana.shub@gmail.com");
        params.put("programme", "QA Automation");
        request.body(params.toJSONString());
        response = request.put("/student/101");

        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test04_DELETE(){
        response = request.delete("/student/100");

        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
