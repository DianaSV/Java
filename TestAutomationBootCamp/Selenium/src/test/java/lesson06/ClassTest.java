package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class ClassTest {
    WebDriver driver;
    String firstName = "Diana";
    String lastName = "Choubaev";

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/pizza/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Test(description = "check start price is 7.50$")
    public void test01_firstPrice(){
        String firstPrice = driver.findElement(By.className("ginput_total")).getText();
        Assert.assertEquals(firstPrice, "$7.50", "Start price is not correct. ");
    }

    @Test(description = "Enter data + check result is as expected")
    @Description("Enter data and make sure the price was updated to 10.50$")
    public void test02_EnterData(){
        driver.findElement(By.id("input_5_22_3")).sendKeys(firstName);
        driver.findElement(By.id("input_5_22_6")).sendKeys(lastName);
        driver.findElement(By.cssSelector("select option[value='Delivery|3']")).click();
        String currentTotalPrice = driver.findElement(By.className("ginput_total")).getText();
        Assert.assertEquals(currentTotalPrice, "$10.50", "After changing to delivery the price is not as expected.");
    }

    @Test(description = "coupon + submission + alert test")
    @Description("Getting number of coupon and copying it to text area. " +
            "Submit the form. " +
            "Make sure alert message is correct and close it. ")
    public void test03_Coupon(){

        String couponNumber = getCouponMoveToTextArea();
        submitForm();
        Alert popup = driver.switchTo().alert();
        String alertText = popup.getText();
        Assert.assertEquals(alertText, firstName + " " + lastName + " " + couponNumber, "Alert text doesn't match expected data.");
        popup.accept();
    }

    @Step
    @Description("Copy coupon from iFrame and insert to text area.")
    public String getCouponMoveToTextArea(){
        WebElement ifrm = driver.findElement(By.cssSelector("iframe[src='coupon.html']"));
        driver.switchTo().frame(ifrm);
        String couponNumber = driver.findElement(By.id("coupon_Number")).getText();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("textarea[name='input_20']")).sendKeys(couponNumber);

        return couponNumber;
    }

    @Step
    @Description("Submit the form. ")
    public void submitForm(){
        driver.findElement(By.id("gform_submit_button_5")).click();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
