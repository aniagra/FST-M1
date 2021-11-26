package porjectActivity;

import org.testng.annotations.Test;

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

public class Activity5 {
	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
 
    @Test
  public void loginWithCorrectCredentials() {
    	
        
        String username = "admin";
        String password = "password";
        
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username);
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password);
        MobileElement loginButton = driver.findElementByXPath("//android.widget.Button[@text = 'Log in']");
        
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement successMessage = driver.findElementByXPath("//android.widget.TextView[@resource-id='action-confirmation']");
        //action-confirmation//Welcome Back, admin//android.widget.TextView
       // Boolean successMessage = wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath("//android.widget.TextView[@resource-id='action-confirmation']"),"Welcome Back, admin"));
        //WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("action-confirmation")));
        
        
       WebElement successMessage = driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]");
       // Assert.assertTrue(successMessage);
        Assert.assertEquals(successMessage.isDisplayed(), true);
        
    }
    
    @Test
    public void loginWithInCorrectCredentials() {
      	
          
          String username = "anisha";
          String password = "passwod";
          
          driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username);
          driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password);
          MobileElement loginButton = driver.findElementByXPath("//android.widget.Button[@text = 'Log in']");
          
          loginButton.click();
          //action-confirmation//Welcome Back, admin//android.widget.TextView
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          WebElement failureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[contains(@text,'Invalid Credentials')]")));
          
          Assert.assertEquals(failureMessage.isDisplayed(), true);
          
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
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View")));
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(2)"));   
    	
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.view.View[contains(@content-desc,'Login Form')]").click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[contains(@text,'Login Form')]"),"Login Form"));
        String loginPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.widget.TextView[contains(@text,'Login Form')]").getText();
        System.out.println("Page title is: " + loginPageTitle);

        // Assertion
        Assert.assertEquals(loginPageTitle, "Login Form");
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
