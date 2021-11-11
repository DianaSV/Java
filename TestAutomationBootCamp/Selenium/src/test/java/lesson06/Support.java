package lesson06;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners(AutomationListeners.class)
public class Support {

    @Step
    public static boolean verifyElements(WebDriver driver) {
        List<WebElement> list = driver.findElements(By.cssSelector(".hero-unit .ms-list .ms-elem-selectable"));
        int i = 3;
        String currentStr = "";

        for (WebElement elem : list) {
            currentStr = elem.getText();
            if(currentStr.equals(""))
                continue;
            String[] splited = currentStr.split(" ");
            if (!splited[0].equals("elem") || Integer.valueOf(splited[1]) != i)
                return false;
            i++;
        }
        return true;
    }
}
