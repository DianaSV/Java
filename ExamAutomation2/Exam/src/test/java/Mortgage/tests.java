package Mortgage;

import General.APIActions;
import General.AutomationListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class tests extends APIActions {
    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.mortgagecalculator.org/");
        mortgagePage = PageFactory.initElements(driver, MortgagePage.class);
    }

    @Test
    public void test01_findCountOfColumns(){
        System.out.println("Number of columns in the table is: " +
                mortgagePage.getListOfBalancePoints().size() + ".");
    }

    @Test
    public void test02_getTableData(){
        for(WebElement elem : mortgagePage.getListOfTableRects()) {
            moveToNextElement(elem);
            System.out.println("Year: "         + mortgagePage.getHoverYear()           .getText());
            System.out.println("Taxes & Fees: " + mortgagePage.getHoverTaxesAndFees()   .getText());
            System.out.println("Interests: "    + mortgagePage.getHoverInterest()       .getText());
            System.out.println("Principal: "    + mortgagePage.getHoverPrincipal()      .getText());
            System.out.println("Balance: "      + mortgagePage.getHoverBalance()        .getText());
            System.out.println();
        }
    }

    @Test
    public void test03_checkBalanceIsUnder250k(){
        SoftAssert soft = new SoftAssert();
        for(WebElement elem : mortgagePage.getListOfTableRects()){
            moveToNextElement(elem);
            double balance = Double.valueOf(mortgagePage.getHoverBalance().getText().
                    replace("$", "").replace(",", ""));
            soft.assertTrue(balance < 250000);
        }
        soft.assertAll("There are balances higher then $250,000 !!!");
    }

    @Step("Hover over the element the function receives.")
    public void moveToNextElement(WebElement elem){
        action = new Actions(driver);
        action.moveToElement(elem).click().build().perform();
    }

    @AfterClass
    public static void endSession(){
        driver.quit();
    }
}
