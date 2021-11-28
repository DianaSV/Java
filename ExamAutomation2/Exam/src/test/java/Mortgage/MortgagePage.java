package Mortgage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgagePage {
    @FindBy(css = "svg g.highcharts-markers path.highcharts-point")
    private static List<WebElement> listOfBalancePoints;

    @FindBy(css = "svg g.highcharts-series.highcharts-series-1 rect")
    private static List<WebElement> listOfTableRects;

    @FindBy(css = "svg > g.highcharts-label text tspan:nth-child(1)")
    private static WebElement hoverYear;

    @FindBy(css = "svg > g.highcharts-label text tspan:nth-child(4)")
    private static WebElement hoverTaxesAndFees;

    @FindBy(css = "svg > g.highcharts-label text tspan:nth-child(7)")
    private static WebElement hoverInterest;

    @FindBy(css = "svg > g.highcharts-label text tspan:nth-child(10)")
    private static WebElement hoverPrincipal;

    @FindBy(css = "svg > g.highcharts-label text tspan:nth-child(13)")
    private static WebElement hoverBalance;


    public static List<WebElement> getListOfBalancePoints(){
        return listOfBalancePoints;
    }

    public static List<WebElement> getListOfTableRects(){
        return listOfTableRects;
    }

    public static WebElement getHoverYear(){
        return hoverYear;
    }

    public static WebElement getHoverTaxesAndFees(){
        return hoverTaxesAndFees;
    }

    public static WebElement getHoverInterest(){
        return hoverInterest;
    }

    public static WebElement getHoverPrincipal(){
        return hoverPrincipal;
    }

    public static WebElement getHoverBalance(){
        return hoverBalance;
    }

}
