package JSoup;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

// https://drive.google.com/file/d/1v13_s5VuKdCt7QS8myKXi2K8lXFP6O2M/view
@Listeners(AutomationListeners.class)
public class BookShop {
    String baseURL = "http://localhost:8080/";
    public static RequestSpecification request;
    public static Response response;
    WebDriver driver;
    Document doc;
    int totalPages = 1;

    @BeforeClass
    public void startSession()  throws IOException {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
        doc = Jsoup.connect("http://localhost:8080/").get();
    }

    @Test(description = "Ex 01")
    @Description("Make sure there are exactly 33 books using JSoup.")
    public void test01_checkThereIs33Books(){
        Elements amount = doc.select("#container div");
        Assert.assertEquals(amount.size() - 3, 33);
    }

    @Test(description = "Ex 02")
    @Description("Sum all of the book prices in each page separately.")
    public  void test02_SumPricesThroughWeb() {
        int pageIndex = 1;
        boolean lastPageFlag = false;
        SoftAssert soft = new SoftAssert();
        goToOrdersPageWeb();

        totalPages = findHowManyPagesTotal();
        driver.get("http://localhost:8080/");
        goToOrdersPageWeb();

        while(pageIndex <= totalPages){
            soft.assertEquals(sumAllPricesInCurrentPageWeb(), sumAllPricesInCurrentPageJSON(pageIndex));
            if(pageIndex < totalPages)
                driver.findElement(By.cssSelector("nav span[class='next'] a")).click();
            pageIndex++;
        }

        soft.assertAll();
    }

    @Test(description = "Ex 03")
    @Description("Sum everything together using the functions from Ex 02.")
    public void test03_sumAllPrices(){
        System.out.println("The overall sum in all pages is: " +
                String.format("%.2f",sumAllPricesInAllPagesTogether()));
    }

    @Step
    @Description("Save in a global parameter the current total number of pages.")
    public int findHowManyPagesTotal(){
        int pageIndex = 1;
        boolean lastPageFlag = false;
        while(!lastPageFlag) {
            driver.findElement(By.cssSelector("nav span[class='next'] a")).click();
            pageIndex++;
            if(driver.findElements(By.cssSelector("nav span[class='next'] a")).size() == 0){
                lastPageFlag = true;
            }
        }
        return pageIndex;
    }

    // Sum all prices in all pages together using "sumAllPricesInCurrentPageJSON" function
    public double sumAllPricesInAllPagesTogether(){
        double sum = 0;
        int pageIndex = 1;
        boolean lastPageFlag = false;
        driver.get("http://localhost:8080/admin/orders?order=id_desc"); //first page
        while(pageIndex <= totalPages){
            sum += sumAllPricesInCurrentPageJSON(pageIndex);
            pageIndex++;
            if(pageIndex < totalPages)
                driver.findElement(By.cssSelector("nav span[class='next'] a")).click();
        }
        return sum;
    }

    // Sum all prices in the current page using Selenium
    public double sumAllPricesInCurrentPageWeb(){
        double sum = 0;
        int amount = driver.findElements(By.cssSelector("tbody tr")).size();
        for(int i = 1; i <= amount; i++) {
            String[] priceSplitDollar = driver.findElement(By.cssSelector("tbody tr:nth-child(" +
                    i + ") td:nth-child(5)")).getText().split("\\$");
            sum += Double.valueOf(priceSplitDollar[1]);
        }
        return sum;
    }

    // Sum all prices in the current page using Rest Assured
    public double sumAllPricesInCurrentPageJSON(int pageIndex) {
        double sum = 0;
        response = request.get("admin/orders.json?order=id_desc&page=" + pageIndex);
        JsonPath jp = response.jsonPath();
        List<String> resIDs = response.jsonPath().get("id");
        int totalItems = resIDs.size();//Integer.valueOf(jp.get(".id.size()").toString());
        for(int i = 0; i < totalItems; i++) {
            sum += Double.valueOf(jp.get("[" + i + "].total_price").toString());
        }
        return sum;
    }

    @Step
    @Description("Move to 'orders' page.")
    public void goToOrdersPageWeb(){
        driver.findElement(By.cssSelector("#flash_notice a:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#orders a")).click();
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
