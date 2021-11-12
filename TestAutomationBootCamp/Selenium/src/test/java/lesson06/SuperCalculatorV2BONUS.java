package lesson06;

import com.google.common.util.concurrent.Uninterruptibles;
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

import java.util.concurrent.TimeUnit;

// Exercise page: https://drive.google.com/file/d/1HOWY7WUo5J8KAT0RrX8nWsGGf4u0gvGb/view
@Listeners(AutomationListeners.class)
public class SuperCalculatorV2BONUS {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.random.org/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Step
    public int getRandomNumber(){
        WebElement ifrm = driver.findElement(By.xpath("//div[@id='homepage-generator']/iframe[@longdesc='https://www.random.org/integers/']"));//cssSelector("#homepage-generator iframe[longdesc='https://www.random.org/integers/']"));
        driver.switchTo().frame(ifrm);
        System.out.println(driver.getCurrentUrl());
        WebElement maxNumElem = driver.findElement(By.cssSelector("input[id$='max']"));
        maxNumElem.clear();
        maxNumElem.sendKeys("10");
        WebElement buttonElem = driver.findElement(By.cssSelector("span input[value='Generate']"));
        buttonElem.click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        WebElement resultElem = driver.findElement(By.cssSelector("center span:nth-child(1)"));
        int result = Integer.parseInt(resultElem.getText());
        driver.switchTo().defaultContent();
        return result;
    }

    //TODO not working properly, 3rd cycle gets wrong sumd
    @Step
    public int multiplyNumbers(int num){
        driver.get("http://juliemr.github.io/protractor-demo/");
        driver.findElement(By.cssSelector("select option:nth-child(4)")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        int countResults = 1, sumOfMultiply = 0;

        for(int i =0; i < num; i++) {
            driver.findElement(By.cssSelector("select option:nth-child(4)")).click();
            driver.findElement(By.cssSelector("form input")).sendKeys(String.valueOf(num));
            driver.findElement(By.cssSelector("form input:nth-child(3)")).sendKeys(String.valueOf(i));
            driver.findElement(By.id("gobutton")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody tr:nth-child(" + countResults + ")")));
            countResults++;
            String resultOfMultiply = driver.findElement(By.cssSelector("form h2")).getText();

            driver.findElement(By.cssSelector("select option:nth-child(1)")).click();
            driver.findElement(By.cssSelector("form input")).sendKeys(String.valueOf(sumOfMultiply));
            driver.findElement(By.cssSelector("form input:nth-child(3)")).sendKeys(String.valueOf(resultOfMultiply));
            driver.findElement(By.id("gobutton")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody tr:nth-child(" + countResults + ")")));
            sumOfMultiply += Integer.valueOf(driver.findElement(By.cssSelector("form h2")).getText());
            countResults++;
        }
        return sumOfMultiply;
    }

    @Test
    public void test01(){
        int randomNumber = getRandomNumber();
        int sum = multiplyNumbers(randomNumber);
        System.out.println("The number is: " + randomNumber +".\nThe sum of multiplys is: " + sum + ".");
    }

    @AfterClass
    public void endSession() {
        driver.quit();
    }
}
