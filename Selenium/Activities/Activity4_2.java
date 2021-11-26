package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Anisha");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Agrawal");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@example.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		driver.quit();

	}

}
