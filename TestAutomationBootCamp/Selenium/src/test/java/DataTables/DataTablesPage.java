package DataTables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DataTablesPage {
    @FindBy(css = "a.next[tabindex='0']")
    private static WebElement nextBtn;

    @FindBy(css = "#example tbody tr")
    private static List<WebElement> tableRows;

    @FindBy(css = "#example thead tr th")
    private static List<WebElement> tableColumns;

    @FindBy(css = "input[type='search']")
    private static WebElement searchInput;

    // Element Getters
    public static WebElement getNextBtn(){
        if(nextBtn.isDisplayed())
            return nextBtn;
        else
            return null;
    }
    public static List<WebElement> getTableColumns(){
        return tableColumns;
    }
    public static List<WebElement> getTableRows(){
        return tableRows;
    }
    public static WebElement getSearchInput(){
        return searchInput;
    }

}