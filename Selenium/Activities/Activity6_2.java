package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/ajax");
		System.out.println(driver.getTitle());
		
		WebElement changeContentButton = driver.findElement(By.xpath("//button[contains(@class,'violet')]"));
		
		changeContentButton.click();
		
		 
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\'ajax-content\']"), "HELLO!"));
		
		String ajaxText = driver.findElement(By.id("ajax-content")).getText();
	    System.out.println(ajaxText);
	    
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        
        //Get late text and print it
        String lateText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(lateText);
 
        //Close browser
        driver.close();

	}

}
