package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LocatorsAdvancedEx01 {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
    }

    @Test
    public void test01_testLocators(){
        List<WebElement> list = new ArrayList<WebElement>();
        list.add(driver.findElement(By.id("locator_id"))); // 1
        list.add(driver.findElement(By.name("locator_name"))); //2
        list.add(driver.findElement(By.tagName("p"))); //3
        list.add(driver.findElement(By.className("locator_class")));// 4
        list.add(driver.findElement(By.partialLinkText("(5)"))); //5
        list.add(driver.findElement(By.linkText("Find my locator (6)"))); //6
        list.add(driver.findElement(By.xpath("//input[@myname='selenium']"))); //7
        list.add(driver.findElement(By.cssSelector("button[class='btn btn-2']"))); //8

        for (WebElement value : list)
            System.out.println(value);
    }

    @Test
    public void test02_Bonus(){
        List<String> list = new ArrayList<String>();
        list.add(driver.findElement(By.id("locator_id")).getText()); // 1
        list.add(driver.findElement(By.name("locator_name")).getText()); //2
        list.add(driver.findElement(By.tagName("p")).getText()); //3
        list.add(driver.findElement(By.className("locator_class")).getText());// 4
        list.add(driver.findElement(By.partialLinkText("myLocator(5)")).getText()); //5
        list.add(driver.findElement(By.linkText("Find my locator (6)")).getText()); //6
        list.add(driver.findElement(By.xpath("//input[@myname='selenium']")).getAttribute("value")); //7
        list.add(driver.findElement(By.cssSelector("button[class='btn btn-2']")).getText()); //8

        for (String value : list)
            System.out.println(value);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
