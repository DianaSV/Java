package lesson06;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ToDoPage extends ToDoList{

//    Actions action = new Actions(driver);

    @FindBy(className = "new-todo")
    private WebElement inputBox;

    @FindBy(css = ".main ul li label")
    private List<WebElement> toDoList;

    @FindBy(css = "a[href='#/completed']")
    private WebElement filterByMissionDoneBtn;

    @FindBy(css = "a[href='#/active']")
    private WebElement filterByMissionUndoneBtn;

    @FindBy(css = "a[href='#/']")
    private WebElement filterShowAllBtn;

    @FindBy(className = "clear-completed")
    private WebElement clearCompletedBtn;

    @Description("Convert WebElement in the list" +
            " to a list of strings that contain the ToDo text values." +
            " Checked cases: empty list, list doesn't have the specific ToDo.")
    private List<String> toDoToStringList(String toDoStr){

        if(toDoList == null) {
            System.out.println("ToDo list is empty.");
            return null;
        }

        List<String> toDoTexts = new ArrayList<String>();
        for(WebElement toDoTxt : toDoList)
            toDoTexts.add(toDoTxt.getText());

        if(!toDoTexts.contains(toDoStr) ){
            System.out.println("No such ToDo!");
            return null;
        }

        return toDoTexts;
    }

    // Add a new To-Do to the list based on specific text of the To-Do
    public void enterNewTodo(String key, Actions action){
        inputBox.sendKeys(key);
        action.sendKeys(Keys.RETURN).build().perform();
    }

    // Delete a To-Do based on specific text of the To-Do
    public void deleteToDo(String toDoStr, Actions action){
        List<String> toDoTexts = toDoToStringList(toDoStr);
        if(toDoTexts == null)
            return;

        int index = toDoTexts.indexOf(toDoStr) + 1;
        WebElement toDeleteElem = driver.findElement(By.cssSelector("section ul li:nth-child(" + index + ")"));
        WebElement deleteBtn = driver.findElement(By.cssSelector("li:nth-child(" + index + ") button"));
        action.moveToElement(toDeleteElem).moveToElement(deleteBtn).click().build().perform();
    }

    // Update a To-Do based on specific text of the To-Do
    public void updateToDo(String toDoStr, String updateTo){
        List<String> toDoTexts = toDoToStringList(toDoStr);
        if(toDoTexts == null)
            return;

        int index = toDoTexts.indexOf(toDoStr) + 1;
        WebElement elemToEdit = driver.findElement(By.cssSelector("section ul li:nth-child(" + index + ")"));
        elemToEdit.click();
        action.doubleClick(elemToEdit).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(updateTo).sendKeys(Keys.RETURN).build().perform();
    }

    // Mark as completed To-Do based on specific text of the To-Do
    public void markAsCompleted(String toDoStr){
        List<String> toDoTexts = toDoToStringList(toDoStr);
        if(toDoTexts == null)
            return;

        int index = toDoTexts.indexOf(toDoStr) + 1;
        driver.findElement(By.cssSelector("section ul li:nth-child(" + index + ") .toggle")).click();
    }

    // Filter by mission done
    public void setFilterByMissionDoneBtn(){
        filterByMissionDoneBtn.click();
    }

    // Filter by mission undone
    public void setFilterByMissionUndoneBtn(){
        filterByMissionUndoneBtn.click();
    }

    // Filter by show all mission
    public void setFilterByShowAllMissions(){
        filterShowAllBtn.click();
    }

    // Clear all completed To-Do
    public void clearAllCompleted(){
        if(clearCompletedBtn.isDisplayed())
            clearCompletedBtn.click();
    }
}
