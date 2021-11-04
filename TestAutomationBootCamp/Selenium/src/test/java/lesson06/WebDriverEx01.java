package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverEx01 {

    private WebDriver driver;
    private String expectedResult = "IMDb: Ratings, Reviews, and Where to Watch" +
            " the Best Movies & TV Shows";
    private String expectedURL = "https://www.imdb.com/";

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.imdb.com/");

    }

    @Test
    public void test01(){
        // Question 4
        driver.navigate().refresh();

        // Question 5 + 6
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedResult);
    }

    @Test
    public void test02(){
        // Question 7
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
