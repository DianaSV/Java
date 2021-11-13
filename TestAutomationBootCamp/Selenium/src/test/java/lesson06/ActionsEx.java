package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
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
    @Description("Drag 'draggable' element to droppable element + make sure the text 'Dropped!' showed up.")
    public void test01(){
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable, droppable).build().perform();
        Assert.assertEquals(droppable.getText(), "Dropped!");
    }

    @Test
    @Description("Select multiple options in a list.")
    public void test02(){
        List<WebElement> list1 = driver.findElements(By.cssSelector("#select_items li"));
        action.clickAndHold(list1.get(1)).clickAndHold(list1.get(2)).build().perform();
    }

    @Test
    @Description("Double click on paragraph to reveal a new element + check the element is revealed.")
    public void test03(){
        WebElement paragraph = driver.findElement(By.id("dbl_click"));
        action.doubleClick(paragraph).build().perform();
        Assert.assertTrue(driver.findElement(By.id("demo")).isDisplayed());
    }

    @Test
    @Description("Hover above paragraph and test the background changed to yellow")
    public void test04(){
        WebElement paragraph = driver.findElement(By.id("mouse_hover"));
        action.moveToElement(paragraph).build().perform();
        Assert.assertEquals(driver.findElement(By.id("mouse_hover")).getAttribute("style"),
                "background-color: rgb(255, 255, 0);");
    }

    @Test
    @Description("Scroll down and make sure the element at the bottom exists.")
    public void test05(){
        Assert.assertTrue(driver.findElement(By.id("scrolled_element")).isEnabled());
        WebElement lowerElementInPage = driver.findElement(By.id("scrolled_element"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", lowerElementInPage);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
