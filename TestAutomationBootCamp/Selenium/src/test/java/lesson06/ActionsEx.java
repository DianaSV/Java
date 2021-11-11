package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsEx {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_actions.html");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    @Test
    public void test01(){
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable, droppable).build().perform();
        Assert.assertEquals(droppable.getText(), "Dropped!");
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
