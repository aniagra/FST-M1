package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println(driver.getTitle());
		
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		
		Alert alertPopup = driver.switchTo().alert();
		
		String alertText = alertPopup.getText();
		System.out.println("Alert text is: " + alertText);
		
		alertPopup.sendKeys("Yes, you are!");
		
		System.out.println(alertPopup.getText());
		
		alertPopup.accept();
		
		driver.close();

	}

}
