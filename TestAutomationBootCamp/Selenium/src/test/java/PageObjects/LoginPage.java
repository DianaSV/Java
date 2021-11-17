package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username2")
    private WebElement userName;

    @FindBy(name = "password2")
    private WebElement password;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public void loginAction(String recUsername, String recPasswrod){
        userName.sendKeys(recUsername);
        password.sendKeys(recPasswrod);
        submitBtn.click();
    }
}
