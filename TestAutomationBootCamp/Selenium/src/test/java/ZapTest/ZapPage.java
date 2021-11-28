package ZapTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZapPage {
    @FindBy(css = "form div:nth-child(1) input")
    private static WebElement userInput;

    @FindBy(css = "form div:nth-child(2) input")
    private static WebElement passInput;

    @FindBy(css = "div.form-group button")
    private static WebElement loginBtn;

    @FindBy(css = "#from")
    private static WebElement fromSelect;

    @FindBy(css = "#to")
    private static WebElement toSelect;

    @FindBy(css = "#dateTo")
    private static WebElement dateInput;

    @FindBy(css = "div button[class='form-control btn btn-default']")
    private static WebElement searchBtn;

    @FindBy(css = "div.container div h4")
    private static WebElement noResults;

    @FindBy(css = "tbody tr td:nth-child(1)")
    private static List<WebElement> recFlightNames;

    @FindBy(css = "tbody tr")
    private static List<WebElement> flightOptionsRows;

    @FindBy(css = "alert div")
    private static WebElement flightIsBooked;

    @FindBy(css = "#page-top > app > nav > div > div:nth-child(3) > ul > li:nth-child(1) > a")
    private static WebElement yourReservationsLink;

    public static WebElement getUserInput(){
        return userInput;
    }

    public static WebElement getPassInput(){
        return passInput;
    }

    public static WebElement getLoginBtn(){
        return loginBtn;
    }

    public static WebElement getFromSelect(){
        return fromSelect;
    }
    public static WebElement getToSelect(){
        return toSelect;
    }

    public static WebElement getDateInput(){
        return dateInput;
    }

    public static WebElement getSearchBtn(){
        return searchBtn;
    }

    public static WebElement getNoResults(){
        return noResults;
    }

    public static List<WebElement> getRecFlightNames(){
        return recFlightNames;
    }

    public static List<WebElement> getFlightOptionsRows(){
        return flightOptionsRows;
    }

    public static WebElement getFlightIsBooked(){
        return flightIsBooked;
    }

    public static WebElement getYourReservationsLink(){
        return yourReservationsLink;
    }
}
