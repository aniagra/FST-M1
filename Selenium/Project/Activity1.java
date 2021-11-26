package LMSproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	@Test
	  public void f() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		System.out.println(driver.getTitle());
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Alchemy LMS – An LMS Application");
		
		

	}
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms/");
	  }
	
	@AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
