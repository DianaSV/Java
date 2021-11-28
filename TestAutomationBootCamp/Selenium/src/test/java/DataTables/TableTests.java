package DataTables;

import org.testng.annotations.*;

//https://drive.google.com/file/d/1iGBgA4mL4VpiKXidBau0-7psl5nVoaTR/view
public class TableTests extends Operations{

    @BeforeClass
    public void startSession(){
        setURL("https://datatables.net/");
        setBrowser();
        navigateToURL();
        //initElems();
    }

    @BeforeMethod
    public void beforeEachMethod(){
        initElems();
    }

    @Test(description = "Test table size")
    public void test02_printTableSize(){
        printSizeOfTable();
    }

    @Test(description = "Get names and ages of people who live in New Your in current page only")
    public void test03_printNamesAgesLiveInNewYorkCurrentPage(){
        System.out.println("People living in New York first page data:");
        printNameAgeNewYorkersCurrentPage();
    }

    @Test(description = "Get names and ages of people who live in New Your in ALL pages")
    public void test04_printNamesAgesLiveInNewYorkAllPages(){
        System.out.println("**************** Test 4 - Print all New Yorkers name and age in all pages. ****************");
        printNameAgeNewYorkersAllPages();
        clearToDefault();
    }

    @Test(description = "Get average salary of specific position type ")
    public void test05_printSalaryAVG(){
        printAverageSalary("Software Engineer");
        clearToDefault();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
