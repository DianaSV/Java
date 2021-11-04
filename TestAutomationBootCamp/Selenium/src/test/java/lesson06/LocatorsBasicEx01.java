package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsBasicEx01 {
    WebDriver driver;

    @BeforeClass
    public void openSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://selenium.dev");
    }

    @Test
    public void test01(){
        System.out.println(driver.findElements(By.id("selenium_logo")));

        System.out.println(driver.findElements(By.className("navbar-logo")));

        System.out.println(driver.findElements(By.className("navbar-brand")));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<WebElement> SeleniumLinks = driver.findElements(By.partialLinkText("Selenium"));
        System.out.println(SeleniumLinks.size());

        List<WebElement> seleniumLinks = driver.findElements(By.partialLinkText("selenium"));
        System.out.println(seleniumLinks.size());
    }

    @AfterClass
    public void closeSession(){
        driver.quit();
    }

}
