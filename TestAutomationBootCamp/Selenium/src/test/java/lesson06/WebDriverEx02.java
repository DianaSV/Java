package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverEx02 {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test01(){
        driver.get("http://www.google.com");
        driver.get("http://www.bing.com");
        driver.navigate().back();
        System.out.println("Title is: " + driver.getTitle());

        if(driver.getPageSource().contains("bubble"))
            System.out.println("The word exists");
        else
            System.out.println("The word doesn't exist");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
