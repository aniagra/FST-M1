package LMSproject;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver;
	WebDriverWait wait ;
	@Test
	  public void f() {
		System.out.println(driver.getTitle());
		
		//login method
		driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]/a")).click();
	      wait.until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
	      System.out.println("title: " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")).click();
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user_login\"]")));
	      driver.findElement(By.id("user_login")).sendKeys("root");
	      driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	      driver.findElement(By.id("wp-submit")).click();
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ld-profile\"]/div[1]/div[1]/div/img")));
	      String homeTitle = driver.findElement(By.xpath("//*[@id=\"menu-item-1510\"]/a")).getText();
	      Assert.assertEquals(homeTitle,"Home");
	      
	      driver.findElement(By.xpath("//*[@id=\"menu-item-1508\"]/a")).click();
			wait.until(ExpectedConditions.titleIs("All Courses – Alchemy LMS"));
			
		
		driver.findElement(By.xpath("//*[@id=\"post-69\"]/a/img")).click();
		WebElement courseContent = driver.findElement(By.xpath("//*[@id=\"learndash_post_69\"]/div/div[3]/div[1]/h2"));  
		String javascript = "arguments[0].scrollIntoView()";  
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript(javascript, courseContent); 
		
		driver.findElement(By.xpath("//*[@id=\"ld-expand-85\"]/div[1]/a/div[2]")).click();
		wait.until(ExpectedConditions.titleIs("Monitoring & Digital Advertising – Alchemy LMS"));
		
		try
		{	
			driver.findElement(By.xpath("//*[@id=\"learndash_post_85\"]/div/div[4]/div[2]/form/input[4]")).click();
			System.out.println("Marked the course as completed");
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Course is already completed");
			
		}
		

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
