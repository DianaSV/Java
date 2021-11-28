package ZapTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Operations extends Variables{
    @Step("Open chrome, set timeout")
    public static void setBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Step("Set global variable URL")
    public static void setURL(String url){
        Variables.url = url;
    }

    @Step("Navigate to URL")
    public static void navigateToURL() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(zapPage.getUserInput()));
    }

    @Step("Init Data Table Page elements.")
    public static void initElems(){
        zapPage = PageFactory.initElements(driver, ZapPage.class);
    }

    @Step("Login")
    public static void login(String username, String password){
        zapPage.getUserInput().sendKeys(username);
        zapPage.getPassInput().sendKeys(password);
        zapPage.getLoginBtn().click();
    }

    @Step
    public static void pickFlight(String from, String destination, String minusOrPlus, int daysCountFromToday){
        zapPage.getFromSelect();
        Select fromDropdown = new Select(zapPage.getFromSelect());
        Select toDropdown = new Select(zapPage.getToSelect());

        fromDropdown.selectByVisibleText(from);
        toDropdown.selectByVisibleText(destination);

        zapPage.getDateInput().clear();
        minusOrPlus.toLowerCase(Locale.ROOT);
        switch (minusOrPlus) {
            case "-":
                zapPage.getDateInput().sendKeys(LocalDate.now().minusDays(daysCountFromToday).toString());
                break;
            case "+":
                zapPage.getDateInput().sendKeys(LocalDate.now().plusDays(daysCountFromToday).toString());
                break;
            default:
                System.out.println("You need to use '-' or '+' sign! Cannot resolve this data." +
                        "Changing to date today.....");
                zapPage.getDateInput().sendKeys(LocalDate.now().toString());
        }
        zapPage.getSearchBtn().click();
    }

    @Step
    public static void isFlightNotFound(){
        Verifications.verifyNoFlights();
    }

    @Step
    public static void lookForFlight(String flightName){
        Verifications.assertNoFlights(zapPage.getRecFlightNames(), flightName);
    }

    @Step
    public static void bookFlightAndVerifyIsBooked(String flightName){
        List<WebElement> listOfFlights = zapPage.getFlightOptionsRows();
        for(WebElement elem : listOfFlights){
            if(elem.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(flightName)){
                elem.findElement(By.cssSelector("td:nth-child(5) span button")).click();
            }
        }
    }

    @Step
    public static void isFlightReserved(String flightName){
        zapPage.getYourReservationsLink().click();
        lookForFlight(flightName);
    }

    @Step
    public static void cancelFlight(String flightName) {
        List<WebElement> listOfFlights = zapPage.getRecFlightNames(); //getFlightOptionsRows();
        Verifications.assertNoFlights(listOfFlights, flightName);
        for (WebElement elem : listOfFlights)
            if (elem.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(flightName)) {
                elem.findElement(By.cssSelector("td:nth-child(7) button")).click();
            }
    }
}
