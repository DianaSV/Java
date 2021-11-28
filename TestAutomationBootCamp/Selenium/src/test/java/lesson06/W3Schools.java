package lesson06;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// https://drive.google.com/file/d/119ZKKLK3k1s-a80N_Lzl04Cz4Tc2LgXs/view

public class W3Schools {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        List<WebElement> rowsNumber = driver.findElements(By.cssSelector("#customers tr"));
        List<WebElement> colsNumber = driver.findElements(By.cssSelector("#customers tr th"));
        System.out.println("Number or rows: " + rowsNumber.size()
                + ". Number of columns is: " + colsNumber.size());
    }

    @Test(description = "Companies located in Germany,")
    @Description("Get all companies which located in Germany. First check if the" +
            "the country equals 'Germany', if so, get the company from the same row.")
    public void test02(){
        List<WebElement> list = driver.findElements(By.cssSelector("#customers tr"));
        for(int i = 2; i < list.size(); i ++){
            String recCountry = driver.findElement(By.cssSelector("#customers tr:nth-child(" + i + ") td:nth-child(" + 3 + ")")).getText().toUpperCase(Locale.ROOT);
            if(recCountry.equals(EnumUtils.isValidEnum(EuropeCoutnries.class, recCountry))){
                System.out.println(driver.findElement(By.cssSelector("#customers tr td:nth-child(" + 1 + ")")).getText());
            }
        }
    }

    @Test
    public void test03() throws IOException {
        List<WebElement> list = driver.findElements(By.cssSelector("#customers tr"));
        List<String[]> listOfStrings = new ArrayList<String[]>();
        String[] rowData = new String[3];

        for(int i = 0; i < list.size() - 1; i++){
            rowData[0] = driver.findElement(By.cssSelector("#customers tr:nth-child(" + (i + 2) + ") td:nth-child(" + 1 + ")")).getText();
            rowData[1] = driver.findElement(By.cssSelector("#customers tr:nth-child(" + (i + 2) + ") td:nth-child(" + 2 + ")")).getText();
            rowData[2] = driver.findElement(By.cssSelector("#customers tr:nth-child(" + (i + 2) + ") td:nth-child(" + 3 + ")")).getText();
            listOfStrings.add(rowData);
        }

        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Automation\\TestAutomationBootCamp\\Selenium\\src\\test\\files\\W3Table.csv"));
        writer.writeAll(listOfStrings);
        writer.close();

        for(int i = 2; i < list.size(); i++){

        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
