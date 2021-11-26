package LMSproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

	WebDriver driver;
	@Test
	  public void f() {
		
		System.out.println(driver.getTitle());
		JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("window.scrollBy(0,1000)");
	      
	      String title =driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getText();
	      System.out.println("title: " + title);
	      Assert.assertEquals(title,"Email Marketing Strategies");
	     

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
