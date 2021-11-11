package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class ErrorHandlingHomeEx{
    WebDriver driver;
    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
    }

    @Test
    public void test01() {
        driver.findElement(By.id("blahblah")).click();
        driver.findElement(By.id("checkbox")).isDisplayed();
        System.out.println("Checkbox exists");
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
