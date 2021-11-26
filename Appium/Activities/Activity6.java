package examples;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @Test
    public void imageScrollTest() {
        // wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.TextView")));
        MobileElement pageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.widget.TextView[2]");
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
 
        // Count the number of images shown on the screen
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        // Assertion before scrolling
        Assert.assertEquals(numberOfImages.size(), 2);
        
        // Scroll to Helen's post android.view.View/android.view.View[2]/android.widget.TextView[2]
        //UiScrollable(UiSelector().scrollable(true)).
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(2)"));
        
        // Find the number of images shown after scrolling
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        // Assertion after scrolling
        Assert.assertEquals(numberOfImages.size(), 4);
    }
    
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel4Emulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("noReset", true);
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

      // Instantiate Appium Driver
      URL remoteUrl = new URL("http://localhost:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
      wait = new WebDriverWait(driver, 40);
      driver.get("https://www.training-support.net/selenium/lazy-loading");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
