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

public class LocatorsBasicEx02 {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void findElements(){
        WebElement centerLogo = driver.findElement(By.className("central-featured-logo"));
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement searchLang = driver.findElement(By.id("searchLanguage"));
        WebElement footer = driver.findElement(By.className("footer-sidebar-content"));

        List<WebElement> list = new ArrayList<WebElement>();
        list.add(centerLogo);
        list.add(searchInput);
        list.add(searchLang);
        list.add(footer);

        for(WebElement value : list){
            System.out.println(value);
        }
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
