package General;

import ExamPack.Variables;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class APIActions extends Variables {
    @Step("Get data from server")
    public static void get(String params){
        response = request.get(params);
    }

    @Step
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("POST Request")
    public static void post(JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.post(baseURL + resource);
        params.clear();
    }

    @Step("PUT Request")
    public static void  put(JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.put(baseURL + resource);
        params.clear();
    }

    @Step("DELETE Request")
    public static void  put(String id){
        response = request.delete(baseURL + "" + id);
    }
}
