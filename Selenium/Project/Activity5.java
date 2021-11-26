package LMSproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;
	WebDriverWait wait ;
	@Test
	  public void f() {
	
		System.out.println(driver.getTitle());
		
	      driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]/a")).click();
	      wait.until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
	      
	      
	      System.out.println("title: " + driver.getTitle());
	      Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
	     


	}
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/lms/");
	  }
	
	@AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
