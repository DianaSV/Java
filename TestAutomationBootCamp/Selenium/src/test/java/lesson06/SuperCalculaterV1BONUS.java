package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class SuperCalculaterV1BONUS {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Step
    public void makeMultiTable() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.findElement(By.cssSelector("select option:nth-child(4)")).click();
        int countResults = 1;

        for(int i =1; i <= 3; i++) {
            for(int j = 1; j <= 3; j++) {
                driver.findElement(By.cssSelector("form input")).sendKeys(String.valueOf(i));
                driver.findElement(By.cssSelector("form input:nth-child(3)")).sendKeys(String.valueOf(j));
                driver.findElement(By.id("gobutton")).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody tr:nth-child(" + countResults + ")")));
                countResults++;
            }
        }
    }

    @Step
    public void printResults(){
        List <WebElement> results = driver.findElements(By.cssSelector("tbody tr td:nth-child(3)"));
        for(WebElement elem : results)
            System.out.println(elem.getText());
    }

    @Test
    public void test01() throws InterruptedException {
        makeMultiTable();
        printResults();
    }

    @AfterClass
    public void endSession(){
        //driver.quit();
    }
}
