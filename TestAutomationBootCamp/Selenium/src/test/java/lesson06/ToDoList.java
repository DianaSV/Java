package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

// https://drive.google.com/file/d/1cONVuyyEd9u8Z95BBjdM0tvKFoNfaFzU/view
@Listeners(AutomationListeners.class)
public class ToDoList {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/#/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        action = new Actions(driver);
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
        action.sendKeys(Keys.RETURN).build().perform();
    }

    @Test
    public void test02_deleteToDo(){
        toDoDeletion();
    }

    @Step
    public void toDoDeletion(){
        WebElement toDeleteElem = driver.findElement(By.cssSelector("ul li div label"));
        WebElement deletionButton = driver.findElement(By.className("destroy"));
        action.moveToElement(toDeleteElem).moveToElement(deletionButton).click();
        action.build().perform();
        System.out.println();
    }

    @Test
    public void test03_upodateToDo(){
        enterNewTodo("My first To Do");
        updateToDo();
    }

    @Step
    public void updateToDo(){
        WebElement elemToEdit = driver.findElement(By.cssSelector(".view"));
        elemToEdit.click();
        action.doubleClick(elemToEdit).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("edited").sendKeys(Keys.RETURN).build().perform();
    }

    @Test
    public void test04_markAsCompleted(){
        markAsCompleted();
    }

    @Step
    public void markAsCompleted(){
        driver.findElement(By.className("toggle")).click();
    }

    @Test
    public void test05_01_filterByMissionDone(){
        driver.findElement(By.cssSelector("a[href='#/completed']")).click();
    }

    @Test
    public void test05_02_filterByMissionUndone(){
        driver.findElement(By.cssSelector("a[href='#/active']")).click();
    }

    @Test
    public void test05_03_filterShowAll(){
        driver.findElement(By.cssSelector("a[href='#/']")).click();
    }

    @Test
    public void test06_ClearCompletedMissions(){
        WebElement clearButton = driver.findElement(By.className("clear-completed"));
        if(clearButton.isDisplayed())
            clearButton.click();
    }

    @AfterClass
    public void endSession(){
        //driver.quit();
    }
}
