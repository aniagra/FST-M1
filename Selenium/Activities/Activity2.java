package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println(driver.getTitle());
		String strId = driver.findElement(By.id("about-link")).getText();
		String strClassName = driver.findElement(By.className("green")).getText();
		String strLinkText = driver.findElement(By.linkText("About Us")).getText();
		String strCSSSelector = driver.findElement(By.cssSelector(".green")).getText();
		
		System.out.println("strId: " + strId);
		System.out.println("strClassName: " + strClassName);
		System.out.println("strLinkText: " + strLinkText);
		System.out.println("strCSSSelector: " + strCSSSelector);
		
		driver.close();
	}

}
