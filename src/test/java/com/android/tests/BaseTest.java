package com.android.tests;

import com.android.util.Helpers;
import com.android.util.PropertyLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(com.android.util.ScreenshotTaker.class)
public class BaseTest {

    public static AppiumDriver driver;

    @BeforeSuite
    public void setUp() throws Exception {
        File app = new File(PropertyLoader.loadProperty("src/test/resources/app.properties", "appPath"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P_API_23");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.UDID, "0139488fe3715743");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        if (driver != null) { driver.quit(); }
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Helpers.init(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
