package examples;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	AndroidDriver<MobileElement> driver;
	  
	  @BeforeClass
	  public void setup() throws MalformedURLException{
			
		  DesiredCapabilities caps = new DesiredCapabilities();
	      //caps.setCapability("deviceId", "2eed910sa");
	      caps.setCapability("deviceName", "Pixel4Emulator");
	      caps.setCapability("platformName", "android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.android.chrome");
	      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	      caps.setCapability("noReset", true);
	      
	      //set appium server URL
	      URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	      
	      //Initialize AndriodDriver
	      driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	      
		}
	  
	  @Test
	  public void testSearchAppium() {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  
	      driver.get("https://www.training-support.net/");
	      
	      String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	      
	      System.out.println("Title on Homepage: " + pageTitle);
	      
	      MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@text = 'About Us']");
	      
	      aboutButton.click();
	      
	      wait.until(ExpectedConditions.invisibilityOf(aboutButton));
	      String newPageTitle = driver
	                .findElementByXPath("//android.view.View/android.view.View/android.view.View[@text='About Us']")
	                .getText();
	 
	        System.out.println("Title on new page: " + newPageTitle);
	        
	        Assert.assertEquals(pageTitle, "Training Support");
	        Assert.assertEquals(newPageTitle, "About Us");
	  }

	  @AfterClass
	  public void afterClass() {
	      driver.quit();
	  }


}
