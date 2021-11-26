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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    
  @SuppressWarnings("deprecation")
@Test
  public void addNote() {
	  
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
			driver.findElementByAccessibilityId("Open navigation drawer").click();
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
