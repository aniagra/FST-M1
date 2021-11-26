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

public class Activity8 {

	WebDriver driver;
	WebDriverWait wait ;
	@Test
	  public void f() {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"menu-item-1506\"]/a")).click();
		wait.until(ExpectedConditions.titleIs("Contact – Alchemy LMS"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,1200)");
	    driver.findElement(By.id("wpforms-8-field_0")).sendKeys("anisha agrawal");
	    driver.findElement(By.id("wpforms-8-field_1")).sendKeys("anisha.agrawal@gmail.com");
	    driver.findElement(By.id("wpforms-8-field_3")).sendKeys("test");
	    driver.findElement(By.id("wpforms-8-field_2")).sendKeys("message");
	    driver.findElement(By.id("wpforms-submit-8")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")));
	    String message = driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")).getText();
	    System.out.println("Message: "+ message);
	    Assert.assertTrue(message.contains("Thanks for contacting us!"));
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
