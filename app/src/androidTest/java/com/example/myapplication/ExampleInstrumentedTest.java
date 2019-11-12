package com.example.myapplication;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ExampleInstrumentedTest {

    public String deviceName = "Galaxy Nexus API 24";
    public String platformName = "Android";
    public String platformVersion = "7.0";
    public String appPackage = "com.isinolsun.app";
    public String appActivity = "com.isinolsun.app.activities.SplashActivity";
    public String url = "http://0.0.0.1:4723/wd/hub";


    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;


    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        driver = new AndroidDriver(new URL(url), caps);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void basicTest() throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/animation_view"))).click();

        //Click I am searching a job
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();


//        //Notification Allow
//        if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size() > 0) {
//            driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
//        }
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.xpath(secondNewJob)));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
