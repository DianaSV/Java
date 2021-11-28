package ExamPack;

import General.APIActions;
import General.AutomationListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.jsoup.Jsoup;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class tests extends APIActions {

    @BeforeClass
    public void startSession() throws IOException {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        doc = Jsoup.connect(baseURL).get();
    }

    @Test
    public void test01(){
        Assert.assertEquals(22,23,"blah");
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
