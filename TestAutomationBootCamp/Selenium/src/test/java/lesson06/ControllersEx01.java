package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ControllersEx01 {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
    }

    @Test
    public void test01_enterValues() {
        {
            driver.findElement(By.name("firstname")).sendKeys("Diana");
            driver.findElement(By.name("lastname")).sendKeys("Choubaev");
            Select myContinent = new Select(driver.findElement(By.id("continents")));
            myContinent.selectByVisibleText("Australia");
        }
    }

    @Test
    public void test02_submitValues(){
        driver.findElement(By.id("submit")).submit();
    }

    @Test
    public void test03_checkURL() {
        String url = driver.getCurrentUrl();

        String[] firstNamePartFromURL = url.split("firstname=");
        String[] lastNamePartFromURL = url.split("lastname=");
        String[] firstName = firstNamePartFromURL[1].split("&");
        String[] lastName = lastNamePartFromURL[1].split("&");

        if(firstName[0] != "" || lastName[0] != "")
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }

    @Test
    public void test04_bonusEnterValues(){
        test01_enterValues();
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-3")).click();
        driver.findElement(By.id("datepicker")).click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        List<WebElement> cells = dateWidget.findElements(By.tagName("td"));
        for(WebElement cell : cells) {
            if (cell.getText().equals("1")) {
                cell.click();
                break;
            }
        }
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("photo")).sendKeys("C:/11 kills.jpg");
        driver.findElement(By.id("tool-1")).click();
        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.xpath("//option[@value='webelement']")).click();
        test02_submitValues();
        String url = driver.getCurrentUrl();
        String[] splitByAnds = url.split("&");
        String recievedDate = "";
        for(int i =0; i<splitByAnds.length; i++){
            if(splitByAnds[i].contains("datepicker")){
                recievedDate = splitByAnds[i];
                break;
            }
        }
        recievedDate = "" + recievedDate.charAt(21) + recievedDate.charAt(22) +
                recievedDate.charAt(23) + recievedDate.charAt(24) + "-" +
                recievedDate.charAt(11) + recievedDate.charAt(12) + "-" +
                recievedDate.charAt(16) + recievedDate.charAt(17);
        System.out.println("The date is: " + recievedDate);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
