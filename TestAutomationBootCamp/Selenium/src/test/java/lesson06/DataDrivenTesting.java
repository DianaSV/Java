package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Listeners(AutomationListeners.class)
public class DataDrivenTesting {
    WebDriver driver;

    @DataProvider(name = "data")
    public Object[][] getDataObject(){
        return new Object[][]{
                {"Israel", "Israel"},
                {"Automation", "Automation"},
                {"BlahBlah","Search results"}
        };
    }

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }



    @Test(dataProvider = "data")
    public void test01(String valueToSearch, String searchResultTitle){
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys(valueToSearch);
        driver.findElement(By.cssSelector(".pure-button")).click();
        Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), searchResultTitle);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
