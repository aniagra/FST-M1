package porjectActivity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
  @Test
  public void testToDo() {
	  
	  String[] taskList = new String[]{"Add tasks to list","Get number of tasks",
	  "Clear the list"};
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //WebDriverWait wait = new WebDriverWait(driver, 10);
	  
      
  	
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View")));
      
     // String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
      
      //System.out.println("Title on Homepage: " + pageTitle);
     // UiScrollable(UiSelector()).scrollIntoView(text("To-Do List"))
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElementByXPath("//android.view.View[contains(@content-desc,'To-Do List')]").click();
      
      
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"To-Do List\"))")).click();
     // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[contains(@text,'To-Do List')]"),"To-Do List"));
      String toDoListPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.widget.TextView[contains(@text,'To-Do List')]").getText();
      System.out.println("Page title is: " + toDoListPageTitle);

      // Assertion
      Assert.assertEquals(toDoListPageTitle, "To-Do List");
      //String taskName = "task1";
      for(String taskName: taskList) {
      driver.findElementByXPath("//android.view.View/android.view.View[1]/android.widget.EditText").sendKeys(taskName);
      
      MobileElement addTaskButton = driver.findElementByXPath("//android.widget.Button[@text = 'Add Task']");
      
      addTaskButton.click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text = '" +taskName+"']")));
      
      MobileElement taskAfteradded = driver.findElementByXPath("//android.widget.TextView[@text = '" +taskName+"']");
      Assert.assertEquals(taskAfteradded.getText(), taskName);
      }
      
     // int strikedTask =0;
      for(String taskName: taskList) {
    	  driver.findElementByXPath("//android.widget.TextView[@text = '" +taskName+"']").click();
    	  System.out.println("clicked on task:" + taskName);
    	 // strikedTask ++;
    	  
      }
      MobileElement clearButton = driver.findElementByXPath("//android.view.View/android.view.View[3]/android.widget.TextView[2]");
      
      clearButton.click();
      
      Boolean invisibilityConfirm =  wait.until(ExpectedConditions.invisibilityOf(driver.findElementByXPath("//android.widget.TextView[@text = '" +taskList[1]+"']")));
        
        Assert.assertTrue(invisibilityConfirm);
       
  }
  
  @BeforeClass
  public void setup() throws MalformedURLException{
		
	  DesiredCapabilities caps = new DesiredCapabilities();
      //caps.setCapability("deviceId", "777acd2a");
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
      wait = new WebDriverWait(driver, 10);
      driver.get("https://www.training-support.net/selenium");
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
