package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ReportingSystem {
    WebDriver driver;

    @Attachment(value = "Page screenshot", type = "impage/png")
    public byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Step
    @Description("Send the data to the website to calculate")
    public void insertValues(int weight, int height){
        driver.findElement(By.id("weight")).sendKeys(String.valueOf(weight));
        driver.findElement(By.id("hight")).sendKeys(String.valueOf(height));
    }

    @Step
    @Description("Make sure the calculated result is mathematically correct.")
    public void checkMathematicalResult(int weight, int height){
        double heightCmToMeters = Double.valueOf(height) / 99; // <<<<<<<<<<< the wrong row, SHOULD BE 100
        int calculatedBMI = (int) Math.round(weight / (heightCmToMeters * heightCmToMeters));
        driver.findElement(By.id("calculate_data")).click();
        try {
            Assert.assertEquals(driver.findElement(By.id("bmi_result")).getAttribute("value"), String.valueOf(calculatedBMI));
        }catch(AssertionError e){
            saveScreenShot(driver);
            Assert.fail("Assert failed");
        }
    }

    @Test(description="Test BMI Calculator")
    @Description("Make sure the elements are found, insert values and check if the result is " +
            "mathematically correct")
    public void test01_BMICalculation(){
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        int weight = ThreadLocalRandom.current().nextInt(50,200);
        int height = ThreadLocalRandom.current().nextInt(50,200);
        insertValues(weight, height);
        checkMathematicalResult(weight, height);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
