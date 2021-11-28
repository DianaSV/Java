package DataTables;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Verifications extends Variables {

    @Step("Verify age is above 22 using soft assert.")
    public static void verifyAge(WebElement elem) {
            soft.assertTrue(Integer.valueOf(elem.findElement(By.cssSelector("td:nth-child(4)")).getText()) > 22,
                    elem.findElement(By.cssSelector("td:nth-child(1)")).getText() + "is underage.");
    }
}

