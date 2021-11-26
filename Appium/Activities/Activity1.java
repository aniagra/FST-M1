package examples;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	AndroidDriver<MobileElement> driver;
  
  @BeforeClass
  public void setup() throws MalformedURLException{
		
	  DesiredCapabilities caps = new DesiredCapabilities();
      //caps.setCapability("deviceId", "2eed910sa");
      caps.setCapability("deviceName", "Pixel4Emulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.calculator2");
      caps.setCapability("appActivity", ".Calculator");
      caps.setCapability("noReset", true);
      
      //set appium server URL
      URL remoteUrl = new URL("http://localhost:4723/wd/hub");
      
      //Initialize AndriodDriver
      driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
      
	}
  
  @Test
  public void additionTest() {
		
		driver.findElementById("digit_5").click();
		//driver.findElementByAndroidUIAutomator("").click();
      driver.findElementById("op_add").click();
      driver.findElementById("digit_4").click();
      driver.findElementById("eq").click();
      
      //Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "9");
		
  }
  
  @AfterClass
  public void afterClass() {
      driver.quit();
  }

}
