import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
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

public class tb2auto {

    private AndroidDriver driver;
    private File imgDir;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "C:\\Users\\s\\Downloads\\Terra Battle 2_v1.0.1_apkpure.com.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        //desiredCapabilities.setCapability("platformVersion", "7.0");
        //desiredCapabilities.setCapability("deviceName", "06157df69302bd1c");
        desiredCapabilities.setCapability("deviceName", "ZY223TH93N");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("fullReset", false);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        //location of screenshots
        File classpathRoot = new File(System.getProperty("user.dir"));
        imgDir = new File(classpathRoot, "src/main/resources");

    }

    @Test
    public void t2auto() throws InterruptedException, IOException {
        Thread.sleep(15000); //start up time

        double height = driver.manage().window().getSize().getHeight();
        double width = driver.manage().window().getSize().getWidth();
        System.out.println("h: " + height + " w: " + width);

        if (height < 1800) { //delete if phone doesn't have digital home button
            height = height + 100;
        }
        int h = (int) (height * 0.09);
        int w = (int) (width * 0.16);

        String battleImg = imgDir + "/battleImg.png";

        while (1>0) {
            Thread.sleep(1000);
            if (Helpers.findImage(driver.getScreenshotAs(OutputType.FILE), battleImg)) { //screenshot matches map
                System.out.println("Found!");
            }
            else{
                System.out.println("...");
            }

        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

