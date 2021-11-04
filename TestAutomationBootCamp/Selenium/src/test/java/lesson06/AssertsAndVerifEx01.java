package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class AssertsAndVerifEx01 {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test01_BMICalculation(){
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        int weight = ThreadLocalRandom.current().nextInt(50,200);
        int height = ThreadLocalRandom.current().nextInt(50,200);
        driver.findElement(By.id("weight")).sendKeys(String.valueOf(weight));
        driver.findElement(By.id("hight")).sendKeys(String.valueOf(height));
        double heightCmToMeters = Double.valueOf(height) / 100;
        int calculatedBMI = (int) Math.round(weight / (heightCmToMeters * heightCmToMeters));

        driver.findElement(By.id("calculate_data")).click();

        Assert.assertEquals(driver.findElement(By.id("bmi_result")).getAttribute("value"), String.valueOf(calculatedBMI));

        System.out.println();
    }

    @Test
    public void test02_calculateButton(){
        System.out.println("The size of the button is: " + driver.findElement(By.id("calculate_data")).getSize());
        System.out.println("Location: X - " + driver.findElement(By.id("calculate_data")).getLocation().x +
                ", Y - " + driver.findElement(By.id("calculate_data")).getLocation().y);
        Assert.assertEquals(driver.findElement(By.id("calculate_data")).isEnabled(), true, "Not enabled");
        Assert.assertEquals(driver.findElement(By.id("calculate_data")).isDisplayed(), true, "Not enabled");
        Assert.assertEquals(driver.findElement(By.id("calculate_data")).isSelected(), false, "Not enabled");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getTagName(), "input", "Wrong tag name");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='calculate_data']")).getAttribute("value"), "Calculate BMI", "Wrong value");
        Assert.assertEquals(driver.findElement(By.id("new_input")).isDisplayed(), false, "Not everything is filled");
    }

    @AfterClass
    public void endSession(){
//        driver.quit();
    }
}
