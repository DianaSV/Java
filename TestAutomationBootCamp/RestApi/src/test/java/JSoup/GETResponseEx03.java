package JSoup;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

// https://drive.google.com/file/d/1owV0YRXS_WoWkbcGKWt0MY9_cfW-hAvy/view
public class GETResponseEx03 {
    String city = "Jerusalem,IL";
    String key = "50f25ac7a285d4c391426452fcf6c043";
    String url = "http://api.openweathermap.org/data/2.5/weather";
    String humidity;

    public static RequestSpecification httpRequest;
    public Response response;

    WebDriver driver;

    @BeforeClass
    public void startSession(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        response = httpRequest.get("?units=metric&q=" + city + "&appid=" + key);
        JsonPath jp = response.jsonPath();
        humidity = jp.get("main.humidity").toString() + "%";
        Assert.assertEquals(jp.get("sys.country").toString(),"IL");
    }

    @Test
    public void test02(){
        driver.get("https://openweathermap.org/");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys("Jerusalem,IL");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("tbody tr td:nth-child(2) a[href='/city/281184']")).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        String[] humiditySplit = (driver.findElement(By.cssSelector("#weather-widget > div.section-content > div.grid-container.grid-4-5 > div.current-container.mobile-padding > div:nth-child(2) > ul > li:nth-child(3)")).getText()).split("\n");
        Assert.assertEquals(humiditySplit[1], humidity);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
