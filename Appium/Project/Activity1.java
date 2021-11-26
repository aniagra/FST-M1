package porjectActivity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Activity1 {
	
	AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    
    
  @Test
  public void createTasks() {
	  
	  String[] taskList = new String[]{"Complete Activity with Google Tasks","Complete Activity with Google Keep",
			  "Complete the second Activity Google Keep"};
		
		  for(String list: taskList) {
		  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
		  AccessibilityId("Create new task")));
		  driver.findElementByAccessibilityId("Create new task").click();
		  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(
		  "add_task_title"))); MobileElement task1Name =
		  driver.findElementById("add_task_title"); task1Name.sendKeys(list);
		  driver.findElementById("add_task_done").click();
		  
		  }
		 
	 wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout[contains(@content-desc,'Complete')]")));
	  List<MobileElement> taskCount = driver.findElementsByXPath("//android.widget.FrameLayout[contains(@content-desc,'Complete')]");
	 
			  
	  Assert.assertEquals(taskCount.size(), 9);
  }
	
  
  
  
  @BeforeClass
  public void setup() throws MalformedURLException{
		
	  DesiredCapabilities caps = new DesiredCapabilities();
      //caps.setCapability("deviceId", "2eed910sa");
     // caps.setCapability("deviceId", "777acd2a");
	  caps.setCapability("deviceName", "Pixel4Emulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
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
