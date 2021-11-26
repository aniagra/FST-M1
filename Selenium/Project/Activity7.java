package LMSproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity7 {

	WebDriver driver;
	WebDriverWait wait ;
	@SuppressWarnings("deprecation")
	@Test
	  public void f() {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"menu-item-1508\"]/a")).click();
		wait.until(ExpectedConditions.titleIs("All Courses – Alchemy LMS"));
		List<WebElement> listOfCourses = driver.findElements(By.className("caption"));
		
		System.out.println("Number of courses:" + listOfCourses.size());
		Assert.assertEquals(3, listOfCourses.size());
	  
	      
	

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
