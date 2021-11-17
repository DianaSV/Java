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
        TouchAction action = new TouchAction(driver);
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Date Widgets']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='2. Inline']")).click();

        MobileElement startElem = driver.findElement(By.xpath("//*[@contentDescription='12']"));
        MobileElement endElem = driver.findElement(By.xpath("//*[@contentDescription='3']"));
        int startX = startElem.getLocation().getX() + (startElem.getSize().getWidth() / 2);
        int startY = startElem.getLocation().getY() + (startElem.getSize().getHeight() / 2);
        int endX = endElem.getLocation().getX() + (endElem.getSize().getWidth() / 2);
        int endY = endElem.getLocation().getY() + (endElem.getSize().getHeight() / 2);
        action.press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();

        startElem = driver.findElement(By.xpath("//*[@contentDescription='15']"));
        endElem = driver.findElement(By.xpath("//*[@contentDescription='45']"));
        startX = startElem.getLocation().getX() + (startElem.getSize().getWidth() / 2);
        startY = startElem.getLocation().getY() + (startElem.getSize().getHeight() / 2);
        endX = endElem.getLocation().getX() + (endElem.getSize().getWidth() / 2);
        endY = endElem.getLocation().getY() + (endElem.getSize().getHeight() / 2);
        action.press(PointOption.point(startX,startY))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='hours']")).getText(), "3");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='minutes']")).getText(), "45");
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

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
