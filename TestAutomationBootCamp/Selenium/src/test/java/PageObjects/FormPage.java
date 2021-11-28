package PageObjects;

import DataTables.Variables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage{
    @FindBy(id = "occupation")
    private WebElement occupationInput;

    @FindBy(id = "age")
    private WebElement ageInput;

    @FindBy(id = "location")
    private WebElement locationInput;

    @FindBy(css = "input[type='button']")
    private WebElement sendFormBtn;

    public void fillFormAction(String occupation, String age, String location){
        occupationInput.sendKeys(occupation);
        ageInput.sendKeys(age);
        locationInput.sendKeys(location);
        sendFormBtn.click();
    }
}
