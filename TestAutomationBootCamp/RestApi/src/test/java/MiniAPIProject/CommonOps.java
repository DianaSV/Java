package MiniAPIProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonOps extends Variables{
    @Step("Update URL")
    public static void setURL(String url){
        Variables.url = url;
    }

    @Step("Navigate to URL")
    public static void navigateToURL(){
        driver.get(url);
    }

    @Step("Initialize API HTTP Request")
    public static void initAPI(){
        RestAssured.baseURI = url;
        request = RestAssured.given();
    }

    @Step("Open chrome browser")
    public static void openChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Step("Close driver")
    public static void closeDriver(){
        driver.quit();
    }
}
