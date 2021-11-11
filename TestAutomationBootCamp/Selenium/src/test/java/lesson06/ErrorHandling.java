package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ErrorHandling {
    WebDriver driver;
    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
    }

    @Test
    public void test01() throws InterruptedException {

        try {
            driver.findElement(By.id("btn")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("checkbox")).isDisplayed();
            System.out.println("Checkbox exists");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test02() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("btn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        if(driver.findElement(By.id("checkbox")).isDisplayed())
            System.out.println("Checkbox exists");
        else
            System.out.println("Checkbox not exists");
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
