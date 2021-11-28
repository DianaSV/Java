package DataTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Operations extends Variables{

    @Step("Open chrome, set timeout")
    public static void setBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Step("Set global variable URL")
    public static void setURL(String url){
        Variables.url = url;
    }

    @Step("Navigate to URL")
    public static void navigateToURL(){
        driver.get(url);
    }

    @Step("Clear list and go to first page of table by default")
    public static void clearToDefault(){
        rowList = null;
        navigateToURL();
    }

    @Step("Store current page data in a list, in a global varaible")
    public static void storeDataCurrentPage(){
        rowList = DataTablesPage.getTableRows();
    }

    @Step("'Next' button appearance check")
    @Description("Try catch for catching the exception without handling it as it is a wanted result" +
            "(finding last page by not finding the button) and we would like to keep the test running.")
    public static boolean clickNextBtn(){
        try {
            if (DataTablesPage.getNextBtn().isDisplayed() == true) {
                DataTablesPage.getNextBtn().click();
                return true;
            }
        }catch (Exception e){}
        return false;
    }

    @Step
    public static void filterBy(String filter){
        DataTablesPage.getSearchInput().sendKeys(filter, Keys.RETURN);
    }

    @Step("Init Data Table Page elements.")
    public static void initElems(){
        dataTablesPage = PageFactory.initElements(driver, DataTablesPage.class);
    }

    @Step("Print number of rows and columns in the table")
    public static void printSizeOfTable(){
        int rows = DataTablesPage.getTableRows().size();
        int columns = DataTablesPage.getTableColumns().size();
        System.out.println("Table size is: " + rows + " rows, " + columns + " columns.");
    }

    @Step("Print out the names and ages of people who live in New York" +
            " in CURRENT page")
    public static void printNameAgeNewYorkersCurrentPage(){
        storeDataCurrentPage();
        for(WebElement elem : rowList) {
            if(elem.findElement(By.cssSelector("td:nth-child(3)")).getText().equals("New York")) {
                System.out.println("Name: " + elem.findElement(By.cssSelector("td:nth-child(1)")).getText()
                        + ", Age: " + elem.findElement(By.cssSelector("td:nth-child(4)")).getText() + ".");
                Verifications.verifyAge(elem);
            }
        }
    }

    @Step("Print out the names and ages of people who live in New York" +
            " in ALL pages")
    public static void printNameAgeNewYorkersAllPages(){
        //SoftAssert soft = new SoftAssert();
        List<WebElement> rowsInAllPagesList = new ArrayList<WebElement>();
        do{
            printNameAgeNewYorkersCurrentPage();
        }while (clickNextBtn());
        // !!!!! The soft errors will be shown TWICE !!!!! - after I've done some searching
        // It appears like a TestNG bug.
        // https://stackoverflow.com/questions/32111960/softassert-shows-error-messages-twice
        // If I change the age in Verifications class statement to age of 50, it will
        // Message twice only for the first 2 people found and the rest will be messaged only once
        soft.assertAll();
    }

    @Step("Print average salary")
    @Description("Filter by 'Software Engineer' position > " +
            "Get current page data >" +
            "Using name element, click on it to reveal salary > " +
            "Add that salary as int(deleting '$' and ',') to summary of all salaries > " +
            "Click on name element again to close salary > " +
            "Go to next page if exists > " +
            "Divide sum by totalHumans and print result")
    public static void printAverageSalary(String position){
        int sum = 0, totalHumans = 0;

        // Filter by people with the desired position
        filterBy(position);
        storeDataCurrentPage();

        // Go through all pages based on "Next" button
        do {
            //Go through current page (current table seen)
            for (WebElement elem : rowList) {
                    WebElement nameElem = elem.findElement(By.cssSelector("td"));
                    nameElem.click(); // open extra row with salary
                    sum += Integer.valueOf(elem.findElement(By.xpath("//span[@class='dtr-data']"))
                            .getText().replace("$","").replace(",", ""));
                    nameElem.click(); // close the extra row
                    totalHumans++;
            }
        }while (clickNextBtn());
        System.out.println("Average salary of Software Engineers is: $" + String.format("%,d", sum / totalHumans) + ".");
    }
}
