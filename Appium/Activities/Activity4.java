package examples;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
  @Test
  public void addContact() {
	  driver.findElementById("contact_name").click();
	  
	  MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
      firstName.sendKeys("abc");
      lastName.sendKeys("Testing");
      phoneNumber.sendKeys("9991284782");
      driver.findElementById("editor_menu_save_button").click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());
      
      String contactName = driver.findElementById("large_title").getText();
      Assert.assertEquals(contactName, "abc Testing");
	  
  }
  @BeforeClass
  public void setup() throws MalformedURLException{
		
	  DesiredCapabilities caps = new DesiredCapabilities();
      //caps.setCapability("deviceId", "2eed910sa");
      caps.setCapability("deviceName", "Pixel4Emulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.contacts");
      caps.setCapability("appActivity", ".activities.ContactEditorActivity");
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
