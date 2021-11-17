package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ClickPage {
    @FindBy(css = "button")
    private WebElement clickMeBtn;

    public void btnDisplayed(){
        Assert.assertTrue(clickMeBtn.isDisplayed());
    }
}
