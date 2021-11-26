package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
        
        WebElement removeCheckbox = driver.findElement(By.xpath("//*[@id='toggleCheckbox']"));
        removeCheckbox.click();
        
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
        
        driver.close();

	}

}
