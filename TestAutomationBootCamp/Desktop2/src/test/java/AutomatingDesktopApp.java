import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AutomatingDesktopApp {

    WindowsDriver driver;
    DesiredCapabilities capabilities;
    String calcApp = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

    @BeforeClass
    public void startSession() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        driver.findElement(By.name("Three")).click();
        driver.findElement(By.name("Multiply by")).click();
        driver.findElement(By.name("Two")).click();
        driver.findElement(By.name("Equals")).click();
    }
}
