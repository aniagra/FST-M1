package porjectActivity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    
  @Test
  public void reminder() {
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
			  AccessibilityId("New text note")));
			  driver.findElementByAccessibilityId("New text note").click();
			  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(
					  "editable_title")));
			  MobileElement note1Title =
					  driver.findElementById("editable_title"); 
			  note1Title.sendKeys("Note1");
			MobileElement note1Desc =
							  driver.findElementById("edit_note_text"); 
			note1Desc.sendKeys("Note1 Description");
			driver.findElementById("com.google.android.keep:id/menu_reminder").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/menu_text")));
			driver.findElementByXPath("//android.widget.TextView[contains(@text,'Pick a date & time')]").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/spinner_inside_error_state")));
			driver.findElementById("com.google.android.keep:id/time_spinner").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/reminder_time_afternoon")));
			driver.findElementById("com.google.android.keep:id/reminder_time_afternoon").click();
			driver.findElementById("com.google.android.keep:id/save").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
			driver.findElementByAccessibilityId("Open navigation drawer").click();
			driver.findElementByAccessibilityId("Open navigation drawer").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/drawer_navigation_reminders")));
			driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders").click();
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\"Note1. Note1 Description. \"]")));
			WebElement description = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Note1. Note1 Description. \"]");
			Assert.assertTrue(description.isDisplayed());
			
	  
  }
  
  
  @BeforeClass
  public void setup() throws MalformedURLException{
		
	  DesiredCapabilities caps = new DesiredCapabilities();
      //caps.setCapability("deviceId", "2eed910sa");
     // caps.setCapability("deviceId", "777acd2a");
	  caps.setCapability("deviceName", "Pixel4Emulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);
      
      //set appium server URL
      URL remoteUrl = new URL("http://localhost:4723/wd/hub");
      
      //Initialize AndriodDriver
      driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
      wait = new WebDriverWait(driver, 5);
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
