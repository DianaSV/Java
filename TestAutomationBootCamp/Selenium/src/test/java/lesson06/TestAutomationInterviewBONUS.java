package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//Exercise page: https://drive.google.com/file/d/1ZoONg2J9EUqLKU6JCBgIfook-bfdx6da/view
@Listeners(AutomationListeners.class)
public class TestAutomationInterviewBONUS {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://loudev.com/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        Assert.assertTrue(Support.verifyElements(driver));
    }

    @AfterClass
    public void endSession(){
        //driver.quit();
    }
}
