package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class AutomatingGraphicElements {

    WebDriver driver;
    Screen screen;
    String path = "C:\\Automation\\Java\\TestAutomationBootCamp\\Selenium\\src\\test\\files\\ImagesForSikuli\\";

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/maps");
        screen = new Screen();
    }

    @Test
    public void test01() throws FindFailed, InterruptedException {
        Thread.sleep(5000);
        Pattern zoomInBtn = new Pattern(path + "plusSign.PNG").similar(90);
        screen.find(zoomInBtn);
        screen.click(zoomInBtn);
        Thread.sleep(5000);
        screen.click(path + "zoomOut.PNG");
        screen.type(path + "searchInput.PNG", "Haifa, Israel");
        screen.click(path + "searchBtn.PNG");
        screen.find(path + "GreatWallOfChina.PNG");
    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
