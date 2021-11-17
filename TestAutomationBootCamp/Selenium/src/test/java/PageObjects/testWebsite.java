package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson06.AutomationListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class testWebsite {

    WebDriver driver;
    LoginPage loginPage;
    FormPage formPage;
    ClickPage clickPage;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://atidcollege.co.il/Xamples/webdriveradvance.html");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
        clickPage = PageFactory.initElements(driver, ClickPage.class);
    }

    @Test
    public void test01() {
        loginPage.loginAction("selenium", "webdriver");
    }

    @Test
    public void test02(){
        formPage.fillFormAction("QA Automation", "25", "Haifa, Israel");
    }

    @Test
    public void test03(){
        clickPage.btnDisplayed();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
