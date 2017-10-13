import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

public class leviEasy {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "C:\\Users\\s\\Downloads\\Terra Battle 2_v1.0.1_apkpure.com.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        //desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("deviceName", "06157df69302bd1c");
        //desiredCapabilities.setCapability("deviceName", "ZY223TH93N");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("fullReset", false);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void leviEasy() throws InterruptedException {
        Thread.sleep(15000); //start up time

        double height = driver.manage().window().getSize().getHeight();
        double width = driver.manage().window().getSize().getWidth();
        System.out.println("h: " + height + " w: " + width);

        if (height < 1800) { //delete if phone doesn't have digital home button
            height = height + 100;
        }
        int h = (int) (height * 0.09);
        int w = (int) (width * 0.16);

        System.out.println("start screen");
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(10000);

        System.out.println("close news");
        (new TouchAction(driver)).tap((int) (width/1080*125),(int) (height/1920*75)).perform();
        Thread.sleep(7000);

        System.out.println("enter quests");
        (new TouchAction(driver)).tap((int) (width/1080*300),(int) (height/1920*700)).perform();
        Thread.sleep(7000);

        System.out.println("pick levi");
        (new TouchAction(driver)).tap((int) (width/1080*540),(int) (height/1920*1200)).perform();
        Thread.sleep(7000);

        System.out.println("pick easy");
        (new TouchAction(driver)).tap((int) (width/1080*540),(int) (height/1920*500)).perform();
        Thread.sleep(7000);

        System.out.println("hit ok");
        (new TouchAction(driver)).tap((int) (width/1080*380),(int) (height/1920*890)).perform();
        Thread.sleep(7000);

        System.out.println("pick friend");
        (new TouchAction(driver)).tap((int) (width/1080*750),(int) (height/1920*730)).perform();
        Thread.sleep(7000);

        System.out.println("hit start");
        (new TouchAction(driver)).tap((int) (width/1080*540),(int) (height/1920*1575)).perform();
        Thread.sleep(12000);

        System.out.println("intro text");
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(5000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(12000);

        System.out.println("first move");
        (new TouchAction(driver)).press((int) (width/1440*135),(int) (height/2560*2175))
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,-3*h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(w,0)
                .waitAction(Duration.ofMillis(500))
                .release()
                .perform();
        Thread.sleep(20000);

        System.out.println("second move");
        (new TouchAction(driver)).press((int) (width/1440*365),(int) (height/2560*1480))
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,-h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,h)
                .waitAction(Duration.ofMillis(500))
                .release()
                .perform();
        Thread.sleep(20000);

        System.out.println("event text");
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(10000);

        System.out.println("third move");
        (new TouchAction(driver)).press((int) (width/1440*365),(int) (height/2560*1480))
                .waitAction(Duration.ofMillis(500))
                .moveTo(w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(w,0)
                .waitAction(Duration.ofMillis(500))
                .release()
                .perform();
        Thread.sleep(20000);

        System.out.println("fourth move");
        (new TouchAction(driver)).press((int) (width/1440*825),(int) (height/2560*1480))
                .waitAction(Duration.ofMillis(500))
                .moveTo(w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(-w,0)
                .waitAction(Duration.ofMillis(500))
                .release()
                .perform();
        Thread.sleep(20000);

        System.out.println("event text");
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(10000);

        System.out.println("boss move");
        (new TouchAction(driver)).press((int) (width/1440*365),(int) (height/2560*2175))
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,-h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(2*w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,-2*h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(-w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,2*h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(-2*w,0)
                .waitAction(Duration.ofMillis(500))
                .moveTo(0,-5*h)
                .waitAction(Duration.ofMillis(500))
                .moveTo(2*w,0)
                .waitAction(Duration.ofMillis(500))
                .release()
                .perform();
        Thread.sleep(20000);

        System.out.println("reward screen");
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap((int) width/2,(int) height/2).perform();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

