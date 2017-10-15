import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.natives.OCR;

public class sbFarm {

    private AndroidDriver driver;
    private File imgDir;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", new File("/Users/smackinnon/Downloads/tb2auto-master/src/main/resources/Terra Battle 2_v1.0.1_apkpure.com.apk"));
        desiredCapabilities.setCapability("platformName", "Android");
        //desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("deviceName", "06157df69302bd1c");
        //desiredCapabilities.setCapability("deviceName", "ZY223TH93N");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("fullReset", false);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        //location of screenshots
        File classpathRoot = new File(System.getProperty("user.dir"));
        imgDir = new File(classpathRoot, "src/main/resources");

    }

    @Test
    public void sbFarm() throws InterruptedException, IOException {
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

        System.out.println("enter story");
        (new TouchAction(driver)).tap((int) (width/1080*780),(int) (height/1920*700)).perform();
        Thread.sleep(7000);

        String battleImg = imgDir + "/battleImg.png";
        System.out.println(driver.currentActivity());

        while (driver.currentActivity().equalsIgnoreCase(".Activity")) {
            File img = driver.getScreenshotAs(OutputType.FILE);
            if(width != 1080){
                Thumbnails.of(img).size(1080,1920).toFile(img);
            }
            if (Helpers.findImage(img, battleImg)) { //screenshot matches map
                System.out.println("Found!");
                System.out.println("move left");
                (new TouchAction(driver)).press((int) (width / 1080 * 450), (int) (height / 1920 * 1050))
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(-w, 0)
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(-w, 0)
                        .waitAction(Duration.ofMillis(250))
                        .release()
                        .perform();

                System.out.println("move down");
                (new TouchAction(driver)).press((int) (width / 1080 * 100), (int) (height / 1920 * 1050))
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, h)
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, h)
                        .waitAction(Duration.ofMillis(250))
                        .release()
                        .perform();

                System.out.println("move up");
                (new TouchAction(driver)).press((int) (width / 1080 * 100), (int) (height / 1920 * 1400))
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, -h)
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, -h)
                        .waitAction(Duration.ofMillis(250))
                        .release()
                        .perform();
            }
            else{
                System.out.println("...");
                (new TouchAction(driver)).tap((int) (width / 1080 * 335), (int) (height / 1920 * 390)).perform();
                System.out.println("map move");
                (new TouchAction(driver)).press((int) (width / 1080 * 540), (int) (height / 1920 * 900))
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, h)
                        .waitAction(Duration.ofMillis(250))
                        .moveTo(0, -h)
                        .waitAction(Duration.ofMillis(250))
                        .release()
                        .perform();
                System.out.println("start battle");
                (new TouchAction(driver)).tap((int) (width / 1080 * 335), (int) (height / 1920 * 390)).perform();
            }

        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

