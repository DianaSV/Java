package lesson06;

import com.google.common.util.concurrent.Uninterruptibles;
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

public class SynchronizationEx {
    WebDriver driver;
    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish2")));
        Assert.assertEquals(driver.findElement(By.id("finish2")).isDisplayed(), true, "Not enough time to render 1st");
    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.id("hidden")).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.id("loading1")).isDisplayed(), false, "Not enough time to render 2nd");
    }

    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.id("btn")).click();
        Assert.assertEquals(driver.findElement(By.id("message")).isDisplayed(), true, "Not enough time to render 3rd");
        System.out.println(driver.findElement(By.id("message")).getText());
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
