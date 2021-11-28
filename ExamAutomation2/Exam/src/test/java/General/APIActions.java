package General;

import Mortgage.Variables;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class APIActions extends Variables{
    @Step("Get data from server")
    public static void get(String params){
        response = request.get(params);
    }

    @Step
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return jp.get(path).toString();
    }
}
