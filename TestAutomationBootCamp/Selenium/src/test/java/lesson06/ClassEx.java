package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassEx {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
    }

    // Read the 'Structure' column and find out the total number of structures present.
    @Test
    public void test01_classEx(){
        List<WebElement> structres = driver.findElements(By.cssSelector(".tsc_table_s13 tr th:first-of-type"));
        int structureCount = 0;
        for(WebElement element: structres) {
            String str = element.getText();
            if(!str.equals("Structure") && !str.equals("Total"))
                structureCount++;
        }
        System.out.println("There are " + structureCount + " structures");
    }

    // Read the value of 'Total' column and match with the previous step.
    @Test
    public void test02_classEx(){
        WebElement element = driver.findElement(By.cssSelector(".tsc_table_s13 tr td"));
        System.out.println(element.getText());
    }

    // Read All the Values from the table row-wise and print them all
    @Test
    public void test03_classEx(){
        List<WebElement> tableElements = driver.findElements(By.cssSelector(".tsc_table_s13 tbody tr"));
        for(WebElement element: tableElements) {
            System.out.println(element.getText() + " | ");
        }
    }

    @Test
    // Verify that Burj Khalifa has a height of 829m (similar for other structures)
    public void test04_classEx(){
        List<WebElement> tableElements = driver.findElements(By.cssSelector(".tsc_table_s13 tbody tr th, td"));
        String expectedHeight = "829m";
        for(int i = 0; i < tableElements.size(); i++) {
            if (tableElements.get(i).getText().equals("Burj Khalifa")) {
                Assert.assertEquals(tableElements.get(i + 3).getText(), expectedHeight, "Not expected height");
                break;
            }
        }
    }
    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
