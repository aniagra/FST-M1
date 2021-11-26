package LMSproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;
	@Test
	  public void f() {
		
		
		System.out.println(driver.getTitle());
		
		WebElement heading = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896\"]/div/div/div/div[1]/h1"));
		System.out.println(heading.getText());
		Assert.assertEquals(heading.getText(),"Learn from Industry Experts");
		
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
