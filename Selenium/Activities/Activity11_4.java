package activities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/tab-opener");
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		
		WebElement button = driver.findElement(By.id("launcher"));
		button.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);
        
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        System.out.println("Current window handle: " + driver.getWindowHandle());
        
        wait.until(ExpectedConditions.titleIs("Newtab"));
        
        System.out.println("New Tab Title is: " + driver.getTitle());
        
        String newTabText = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println("New tab heading is: " + newTabText);
 
        //Open Another Tab
        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
 
        //Make sure the new tab's handle is part of the handles set
        allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);
        
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
 
        //Print the handle of the current window
        System.out.println("New tab handle: " + driver.getWindowHandle());
 
        //Wait for the newest tab to load completely
        wait.until(ExpectedConditions.titleIs("Newtab2"));
 
        //Print New Tab Title
        System.out.println("New Tab Title is: " + driver.getTitle());
 
        //Get heading on new page
        newTabText = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println("New tab heading is: " + newTabText);
 
        //Close the browser
        driver.quit();
		
		

	}

}
