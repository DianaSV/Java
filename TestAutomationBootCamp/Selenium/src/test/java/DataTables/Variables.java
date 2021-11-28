package DataTables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class Variables {
    protected static WebDriver driver;
    protected static String url;

    protected static DataTablesPage dataTablesPage = new DataTablesPage();
    protected static List<WebElement> rowList;
    protected static SoftAssert soft = new SoftAssert();
}
