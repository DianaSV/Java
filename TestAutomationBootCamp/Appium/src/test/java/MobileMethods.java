import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class MobileMethods {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ac58c4ec");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void test01() {
        List<AndroidElement> list = driver.findElements(By.xpath("//*[@id='list']/*"));
        Assert.assertEquals(list.size(), 11, "Number of options in the list is not 11.");
    }

    @Test
    public void test02(){
        Rectangle elem = driver.findElement(By.xpath("//*[@text='Content']")).getRect();
        System.out.println("Dimensions: " + elem.getWidth() + "," + elem.getHeight() + ". " +
                "Coordinates: " + elem.x + "," + elem.y + ".");
    }

    @Test
    public void test03(){
        System.out.println("Current activity: " + driver.currentActivity() + ", Current time: " + driver.getDeviceTime());
    }

    @Test
    public void test04(){
        Assert.assertTrue(driver.isAppInstalled("com.experitest.ExperiBank"), "App is not installed.");
    }

    @Test
    public void test05() throws InterruptedException {
        if(driver.getOrientation() == ScreenOrientation.PORTRAIT){
            driver.rotate(ScreenOrientation.LANDSCAPE);
            Thread.sleep(4000);
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @Test
    public void test06() throws IOException {
        driver.openNotifications();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:/Automation/Screenshots/screenshot1.png"));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:/Automation/Screenshots/screenshot2.png"));
    }

    // For some reason it works the other way around
    // Function isDeviceLocked returns TRUE if device is UNLOCKED
    @Test
    public void test07() throws InterruptedException {
        if(driver.isDeviceLocked() == true){
            driver.lockDevice();
            Thread.sleep(3000);
            driver.unlockDevice();
            Assert.assertTrue(driver.isDeviceLocked());
        }
    }

    @Test
    public void test08(){
        String originalCode = driver.getPageSource();
        Assert.assertEquals(StringUtils.countMatches(originalCode, "ListView") , 4);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}