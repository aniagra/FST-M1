package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("firstName")).sendKeys("Anisha");
		driver.findElement(By.id("lastName")).sendKeys("Agrawal");
		driver.findElement(By.id("email")).sendKeys("test@example.com");
		driver.findElement(By.id("number")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		Thread.sleep(1000);
		driver.quit();
	}

}
