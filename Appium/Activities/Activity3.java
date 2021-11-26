package examples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
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
	    public void add() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_add").click();
	        driver.findElementById("digit_9").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "14");
	    }
	  
	  @Test
	    public void subtract() {
	        driver.findElementById("digit_1").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("op_sub").click();
	        driver.findElementById("digit_5").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "5");
	    }
	  
	  @Test
	    public void multiply() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_mul").click();
	        driver.findElementById("digit_1").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("digit_0").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "500");
	    }
	  
	  @Test
	    public void divide() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("op_div").click();
	        driver.findElementById("digit_2").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "25");
	    }
	  
	  @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
