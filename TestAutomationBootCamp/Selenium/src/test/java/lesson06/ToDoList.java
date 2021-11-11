package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class ToDoList {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/#/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Test(description = "Add a new ToDo")
    @Description("Enter a value in the text box > press enter > test if it exists. ")
    public void test01_addNewToDo(){
        enterNewTodo("My first To Do");
        Assert.assertEquals(driver.findElement(By.cssSelector("li div label")).getText(), "My first To Do", "To Do is diffrent then entered");
    }

    @Step
    public void enterNewTodo(String key){
        driver.findElement(By.className("new-todo")).sendKeys(key);
        WebElement inputElem = driver.findElement(By.className("new-todo"));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN).build().perform();
    }

    @Test
    public void test02_deleteToDo(){
        toDoDeletion();
    }

    @Step
    public void toDoDeletion(){
        Actions action = new Actions(driver);
        WebElement toDeleteElem = driver.findElement(By.cssSelector("ul li div label"));
        WebElement deletionButton = driver.findElement(By.className("destroy"));
        action.moveToElement(toDeleteElem).moveToElement(deletionButton).click();
        action.build().perform();
        System.out.println();
    }

    @Test
    public void test03_upodateToDo(){
        enterNewTodo("My first To Do");

    }

    @Step
    public void updateToDo(){
        WebElement dClick =  driver.findElement(By.xpath("//input[@class='edit']"));
        System.out.println(dClick.getAttribute("value"));
        Actions action = new Actions(driver);
        action.moveToElement(dClick).doubleClick(dClick).build().perform();
        dClick.click();
        System.out.println();
    }

    @AfterClass
    public void endSession(){
        //driver.quit();
    }
}
