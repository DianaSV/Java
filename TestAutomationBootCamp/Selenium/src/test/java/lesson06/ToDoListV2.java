package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

// https://drive.google.com/file/d/1cONVuyyEd9u8Z95BBjdM0tvKFoNfaFzU/view
@Listeners(AutomationListeners.class)
public class ToDoListV2 {
    public WebDriver driver;
    public ToDoPage toDoPage;
    public Actions action;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/#/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        action = new Actions(driver);
        toDoPage = PageFactory.initElements(driver, ToDoPage.class);
    }

    @Test(description = "Add a new ToDo")
    @Description("Enter a value in the text box > press enter > test if it exists. ")
    public void test01_addNewToDo(){
        toDoPage.enterNewTodo("My first To Do", action);
        toDoPage.enterNewTodo("My second To Do", action);
        toDoPage.enterNewTodo("My third To Do", action);
    }

    @Test(description = "Delete ToDo")
    public void test02_deleteToDo(){
        toDoPage.deleteToDo("My second To Do", action);
    }

    @Test(description = "Update ToDo")
    public void test03_updateToDo(){
        toDoPage.enterNewTodo("My fourth To Do");
        toDoPage.updateToDo("My fourth To Do", "Edited To Do");
    }

    @Test(description = "Mark as completed a ToDo")
    public void test04_markAsCompleted(){
        toDoPage.markAsCompleted("Edited To Do");
    }

    @Test
    public void test05_01_filterByMissionDone(){
        toDoPage.setFilterByMissionDoneBtn();
    }

    @Test
    public void test05_02_filterByMissionUndone(){
        toDoPage.setFilterByMissionUndoneBtn();
    }

    @Test
    public void test05_03_filterShowAll(){
        toDoPage.setFilterByShowAllMissions();
    }

    @Test
    public void test06_ClearCompletedMissions(){
        toDoPage.clearAllCompleted();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}

