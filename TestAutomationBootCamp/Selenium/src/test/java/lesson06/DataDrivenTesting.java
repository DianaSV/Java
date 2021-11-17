package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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

    // Take data from this class
    @Test(dataProvider = "data")
    @Description("Take data from this class.")
    public void test01(String valueToSearch, String searchResultTitle){
        //enterValuesAndCheckResult(valueToSearch, searchResultTitle);
    }

    // Take data from different class + from CSV file
    @Test(dataProvider = "data", dataProviderClass = DataDrivenTestingBONUS.class)
    @Description("Take the values from different class.")
    public void test02_BONUS(String valueToSearch, String searchResultTitle){
        enterValuesAndCheckResult(valueToSearch, searchResultTitle);
    }

    @Step
    public void enterValuesAndCheckResult(String valueToSearch, String searchResultTitle){
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
