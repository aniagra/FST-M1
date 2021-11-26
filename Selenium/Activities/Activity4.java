package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println(driver.getTitle());
		String textAboutUs = driver.findElement(By.xpath("//a[@id ='about-link']")).getText();
		System.out.println(textAboutUs);
		
		driver.findElement(By.xpath("//a[@id ='about-link']")).click();
		
		System.out.println("Title of the page after clicking on about us link: " +driver.getTitle());
		
		driver.close();
	}

}
