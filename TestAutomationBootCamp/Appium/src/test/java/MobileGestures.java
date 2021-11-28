import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class MobileGestures {
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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Date Widgets']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='2. Inline']")).click();

        switchHours();
        switchMinutes();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='hours']")).getText(), "9");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='minutes']")).getText(), "45");
    }

    @Step
    public void switchHours(){
        TouchAction action = new TouchAction(driver);

        MobileElement startElem = driver.findElement(By.xpath("//*[@contentDescription='12']"));
        MobileElement endElem = driver.findElement(By.xpath("//*[@contentDescription='9']"));
        int startX = startElem.getLocation().getX() + (startElem.getSize().getWidth() / 2);
        int startY = startElem.getLocation().getY() + (startElem.getSize().getHeight() / 2);
        int endX = endElem.getLocation().getX() + (endElem.getSize().getWidth() / 2);
        int endY = endElem.getLocation().getY() + (endElem.getSize().getHeight() / 2);
        action.press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    @Step
    public void switchMinutes(){
        TouchAction action = new TouchAction(driver);

        MobileElement startElem = driver.findElement(By.xpath("//*[@contentDescription='15']"));
        MobileElement endElem = driver.findElement(By.xpath("//*[@contentDescription='45']"));
        int startX = startElem.getLocation().getX() + (startElem.getSize().getWidth() / 2);
        int startY = startElem.getLocation().getY() + (startElem.getSize().getHeight() / 2);
        int endX = endElem.getLocation().getX() + (endElem.getSize().getWidth() / 2);
        int endY = endElem.getLocation().getY() + (endElem.getSize().getHeight() / 2);
        action.press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    @Test
    public void test02(){
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.xpath("//*[@contentDescription='Expandable Lists']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='1. Custom Adapter']")).click();
        MobileElement elem = driver.findElement(By.xpath("(//*[@id='list']/*[@text])[1]"));
        TouchAction action = new TouchAction(driver);
        action.longPress(new LongPressOptions()
                .withElement(ElementOption.element(elem))
                .withDuration(Duration.ofSeconds(2)))
                .perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.ListView']")).isDisplayed(), "The window didn't show up.");

    }
}
