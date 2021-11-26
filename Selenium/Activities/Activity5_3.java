package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement textboxInput = driver.findElement(By.xpath("//*[@id=\'input-text']"));
        System.out.println("The checkbox Input is displayed: " + textboxInput.isEnabled());
        
        WebElement enableInput = driver.findElement(By.xpath("//*[@id='toggleInput']"));
        enableInput.click();
        
        System.out.println("The checkbox Input is displayed: " + textboxInput.isEnabled());
        
        driver.close();
	}

}
