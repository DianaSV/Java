package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ExternalFiles {
    WebDriver driver;
    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public String getData(String nodeName){
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Config/config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e){
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    @Step("Insert values")
    public void insertValues(){
        driver.get(getData("URL"));
        driver.findElement(By.id("weight")).sendKeys(getData("Kilograms"));
        driver.findElement(By.id("hight")).sendKeys(getData("Centimeters"));
    }

    @Step("Submit and make sure the value is correct")
    public void checkResult(){
        driver.findElement(By.id("calculate_data")).click();
        Assert.assertEquals(driver.findElement(By.id("bmi_result")).getAttribute("value"), getData("ExpectedResult"));
    }

    @Test(priority = 0, description="Correct calculation test")
    @Description("A test to calculate and make sure the received result is mathematically correct.")
    public void test01(){
//        driver.get(getData("URL"));
//        driver.findElement(By.id("weight")).sendKeys(getData("Kilograms"));
//        driver.findElement(By.id("hight")).sendKeys(getData("Centimeters"));
        insertValues();
//        driver.findElement(By.id("calculate_data")).click();
//        Assert.assertEquals(driver.findElement(By.id("bmi_result")).getAttribute("value"), getData("ExpectedResult"));
        checkResult();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
