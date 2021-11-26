package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
		
		WebElement toggleCheckbox = driver.findElement(By.xpath("//*[@id='toggleCheckbox']"));
		
		toggleCheckbox.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		toggleCheckbox.click();
		
		wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        
        driver.close();

	}

}
