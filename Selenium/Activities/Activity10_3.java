package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/drag-drop");
		System.out.println(driver.getTitle());
		Actions actions = new Actions(driver);
		
		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement dropZone1 = driver.findElement(By.id("droppable"));
		WebElement drop2 = driver.findElement(By.id("dropzone2"));
		
		
		actions.dragAndDrop(ball, dropZone1).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");
        
        actions.dragAndDrop(ball, drop2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop2, "background-color"));
        System.out.println("ENTERED DROPZONE 2");
        
        // Close the browser
        driver.close();
		
		

	}

}
