package lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class AutomatingGraphicElements {

    WebDriver driver;
    Screen screen;
    String path = "C:\\Automation\\TestAutomationBootCamp\\Selenium\\src\\test\\files\\ImagesForSikuli\\";

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        //ChromeOptions object
        ChromeOptions opt = new ChromeOptions();
        //set language to English
        opt.addArguments("lang=en-GB");
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://maps.google.com");
        screen = new Screen();
    }

    @Test
    public void test01() throws FindFailed, InterruptedException {
        Thread.sleep(1000);
        screen.click(path + "zoomIn.PNG");
        Thread.sleep(1000);
        screen.click(path + "zoomOut.PNG");
        Thread.sleep(1000);
        screen.click(path + "searchInput.PNG");
        screen.type(path + "searchInput.PNG", "Haifa, Israel");
        screen.click(path + "searchBtn.PNG");
        Thread.sleep(1000);
        screen.find(path + "GreatWallOfChina.PNG");
        Thread.sleep(1000);
    }

    @AfterClass
    public void endSession(){
        //driver.quit();
    }
}
