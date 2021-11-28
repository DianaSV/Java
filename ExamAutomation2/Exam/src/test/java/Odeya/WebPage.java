package Odeya;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebPage {

    @FindBy(xpath = "//div[@id='area_chart']//*[name()='g'][@class='highcharts-series highcharts-series-0 highcharts-column-series highcharts-tracker']//*[name()='rect']")
    public List<WebElement> cols;

    @FindBy(xpath = "(//*[name()='svg'])[1]//*[name()='g'][12]//*[name()='text']/*")
    public List<WebElement> text;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='g'][@class='highcharts-markers highcharts-series-3 highcharts-spline-series highcharts-tracker']//*[name()='path']")
    //@FindBy(xpath = "(//*[@id='area_chart']//*[name()='g'])[15]//*[name()='path']")
    //@FindBy(xpath = "(//*[name()='g'])[15]//*[name()='path']")
    @FindBy(xpath = "(//*[@id='area_chart']//*[name()='g'])[15]//*[name()='path'][@class='highcharts-point']")
    public static List<WebElement> points;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='svg']//*[name()='g'][12]//*[name()='text']//*[name()='tspan'][1]")
    @FindBy(xpath = "(//*[name()='text']//*[name()='tspan'])[1]")
    public WebElement year;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='svg']//*[name()='g'][12]//*[name()='text']//*[name()='tspan'][4]")
    @FindBy(xpath = "(//*[name()='text']//*[name()='tspan'])[4]")
    public WebElement taxesAndFees;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='svg']//*[name()='g'][12]//*[name()='text']//*[name()='tspan'][7]")
    @FindBy(xpath = "(//*[name()='text']//*[name()='tspan'])[7]")
    public WebElement interest;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='svg']//*[name()='g'][12]//*[name()='text']//*[name()='tspan'][10]")
    @FindBy(xpath = "(//*[name()='text']//*[name()='tspan'])[10]")
    public WebElement principal;

    //@FindBy(xpath = "//*[@id='area_chart']//*[name()='svg']//*[name()='g'][12]//*[name()='text']//*[name()='tspan'][13]")
    @FindBy(xpath = "(//*[name()='text']//*[name()='tspan'])[13]")
    public WebElement balance;

    public List<String> balanceList;
    public Double balanceDouble;

    //@FindBy(xpath = "(//*[name()='tspan'])[13]")
//    @FindBy(xpath = "//*[text()='Balance']")
//    public List<WebElement> balance;
//
//    @FindBy(xpath = "//*[text()='Taxes & Fees']")
//    public List<WebElement> taxes;
//
//    @FindBy(xpath ="//*[text()='Interest']" )
//    public List<WebElement> interest;
//
//    @FindBy(xpath ="//*[text()='Principal']")
//    public List<WebElement> principal;

    @Step("Q1 - cols table")
    public void printCols() {
        System.out.println("Cols Size: " + cols.size()); //31
    }

    @Step("Q2")
    public void q2(){

    }

//    @Step("Q2")
//    public void q2() {
//        for (int i = 0; i < cols.size(); i++) {
//            if (text.get(i).isDisplayed()) {
//                System.out.println(taxes.get(i).getAttribute("textContent"));
//                System.out.println(interest.get(i).getAttribute("textContent"));
//                System.out.println(principal.get(i).getAttribute("textContent"));
//                System.out.println(balance.get(i).getAttribute("textContent"));
//            }
//        }
//    }

//    @Step("Q3")
//    public void q3(){
//        for(int i=0;i<cols.size();i++){
//            System.out.println(balance.get(i).getAttribute("textContent"));
//            String balance1=balance.get(i).getText();
//            String balance2= balance1.substring(1);
//            String balanceSplit= balance2.replaceAll(",","");
//            Assert.assertTrue(Double.parseDouble(balance.get()getAttribute("textContent"))<250000);
//            System.out.println("Balance smaller than 250,000 ");
//        }
//    }
}