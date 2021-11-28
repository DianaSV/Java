package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ElectronApps {
    public WebDriver driver;
    public ChromeOptions opt;
    public DesiredCapabilities capabilities;

    @BeforeClass
    public void startSession(){
        System.setProperty("webdriver.chrome.driver", "C:/electrondriver.exe");
        opt = new ChromeOptions();
        opt.setBinary("C:/Automation/Electron/Electron API Demos.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", opt);
        capabilities.setBrowserName("chrome");
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
          driver.findElement(By.id("button-windows")).click();
          driver.findElement(By.id("button-ex-links-file-manager")).click();
          driver.findElement(By.id("open-ex-links-demo-toggle")).click();

    }

    @AfterClass
    public void endSession(){
        driver.quit();
    }
}
