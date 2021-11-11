package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchAndNavi {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Ex01
        driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");
    }

    @Test
    public void test02() {
        // Ex02
        driver.findElement(By.id("btnAlert")).click();
        Alert popup = driver.switchTo().alert();
        System.out.println(popup.getText());
        popup.accept();
        Assert.assertEquals(driver.findElement(By.id("output")).isDisplayed(), true, "Not displayed");
        Assert.assertEquals(driver.findElement(By.id("output")).getText(), "Alert is gone.", "Unexpected string.");
    }

    @Test
    public void test03() {
        // Ex03
        String myName = "Diana";
        driver.findElement(By.id("btnPrompt")).click();
        Alert popup = driver.switchTo().alert();
        popup.sendKeys(myName);
        popup.accept();
        Assert.assertEquals(driver.findElement(By.id("output")).getText(), myName, "Unexpected string");
    }

    @Test
    public void test04() {
        // Ex04
        WebElement ifrm = driver.findElement(By.tagName("iframe"));
        String strToCompare = "This is an IFrame !";
        driver.switchTo().frame(ifrm);
        System.out.println(driver.findElement(By.id("iframe_container")).getText());
        Assert.assertEquals(driver.findElement(By.id("iframe_container")).getText(), strToCompare, "Unexpected string in iFrame");

        driver.switchTo().defaultContent();
    }

    @Test
    public void test05() {
        // Ex05
        String mainTab = driver.getWindowHandle();
        driver.findElement(By.id("btnNewTab")).click();
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);
        String receivedStringFromNewTab = driver.findElement(By.id("new_tab_container")).getText();
        String expectedStringFromNewTab = "This is a new tab";
        System.out.println(receivedStringFromNewTab);
        Assert.assertEquals(receivedStringFromNewTab, expectedStringFromNewTab, "Not the expected string in the new tab");

        driver.close();
        driver.switchTo().window(mainTab);
    }

    @Test
    public void test06() {
        // Ex06
        String mainTab = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[href='ex_switch_newWindow.html']")).click();
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);
        String receivedStringFromNewTab = driver.findElement(By.id("new_window_container")).getText();
        String expectedStringFromNewTab = "This is a new window";
        Assert.assertEquals(receivedStringFromNewTab, expectedStringFromNewTab, "Not the expected string in the new window");

        driver.close();
        driver.switchTo().window(mainTab);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
