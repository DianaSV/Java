package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

// Exercise page: https://docs.google.com/document/d/1wfyNVK0RwYuV5a6n1GHi8jYMSH9E1dIH9TUg_VRDIYs/edit

@Listeners(AutomationListeners.class)
public class NopCommerceBONUS {
    WebDriver driver;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @Step
    public void goToPageCameraAndPhoto(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
    }

    @Step
    public void filterFromLowPriceToHighPrice(){
        driver.findElement(By.cssSelector("#products-orderby > option[value='10']")).click();
    }

    @Step
    public int countItems(){
        List<WebElement> itemCount = driver.findElements(By.cssSelector(".item-grid .item-box"));
        return itemCount.size();
    }

    @Step
    public boolean nameEqualsToExpected(String expected){
        List<WebElement> items = driver.findElements(By.cssSelector(".item-grid .product-title"));
        for(WebElement elem : items){
            String sourceTitle = elem.getText();
            if(sourceTitle.contains(expected))
                return true;
        }
        return false;
    }

    @Step
    public boolean higherThen3Stars(){
        List<WebElement> items = driver.findElements(By.cssSelector(".item-grid .rating div"));
        for(WebElement elem : items) {
            String widthAttribute = elem.getAttribute("style");
            String[] width = widthAttribute.split("[: %]");
            if(Integer.valueOf(width[2]) < 0 )
                return false;
        }
        return true;
    }

    @Test
    public void testCase01(){
        goToPageCameraAndPhoto();
        filterFromLowPriceToHighPrice();
        Assert.assertEquals(countItems(), 3);
        Assert.assertEquals(nameEqualsToExpected("Nikon D5500 DSLR"),true);
        Assert.assertEquals(higherThen3Stars(),true);
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
