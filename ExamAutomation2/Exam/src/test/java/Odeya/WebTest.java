package Odeya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collection;


public class WebTest {
    WebDriver driver;
    WebPage page;

    @BeforeClass
    public void startUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
       //driver.manage().window().maximize();
        Thread.sleep(3000);
        page= PageFactory.initElements(driver,WebPage.class);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test
    public void test01()  {
        page.printCols();
    }

    @Test
    public void test02() throws InterruptedException {
        System.out.println("Point size: "+page.points.size());
        for(int i = 0; i < page.points.size() ; i++){
            Actions action=new Actions(driver);
            action.moveToElement(page.points.get(i)).moveToElement(page.points.get(i)).click().build().perform();
            System.out.println("Year: " + page.year.getAttribute("textContent"));
            System.out.println("Taxes&Fees: "+page.taxesAndFees.getAttribute("textContent"));
            System.out.println("Interest: " + page.interest.getAttribute("textContent"));

            System.out.println("Principal: "+page.principal.getAttribute("textContent"));
            System.out.println("Balance: "+page.balance.getAttribute("textContent"));
            System.out.println(" ");
            }
    }

    @Test
    public void test03() throws InterruptedException {
        page.balanceList=new ArrayList<>();
        Actions action=new Actions(driver);
        for(int i=0;i<=page.points.size();i++){
            action.moveToElement(page.points.get(i)).moveToElement(page.points.get(i)).click();
            action.build();
            action.perform();
            Thread.sleep(2000);
            System.out.println("Balance: "+page.balance.getAttribute("textContent"));
            String balance=page.balance.getAttribute("textContent");
            String balanceWithout= balance.substring(1);
            String balanceReplace= balanceWithout.replaceAll("," , "");
            page.balanceList.add(balanceReplace);
            page.balanceDouble=Double.parseDouble(balanceReplace);
        }
        System.out.println(page.balanceList);
        SoftAssert softAssert= new SoftAssert();
        for(int j=0;j<page.balanceList.size();j++){
            softAssert.assertTrue(page.balanceDouble<250000.0);
            softAssert.assertAll();
        }
    }


//    @Test
//    public void test02() throws InterruptedException {
////        Actions action= new Actions(driver);
////        for(int i=0;i<page.text.size();i++){
////            action.moveToElement(page.text.get(i));
////            Thread.sleep(2000);
////            System.out.println(page.text.get(i).getAttribute("textContent"));
////        }
//        page.q2();
//    }

//    @Test
//    public void test03(){
//        page.q3();
//    }
}