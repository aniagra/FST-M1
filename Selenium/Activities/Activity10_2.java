package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println(driver.getTitle());
		WebElement pressedKey = driver.findElement(By.id("keyPressed"));
		Actions actions = new Actions(driver);
		
		actions.sendKeys("A").build().perform();
		String pressedKeyText = pressedKey.getText();
		System.out.println("Pressed key is: " + pressedKeyText);
		
		Action actionSeq = actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build();
		actionSeq.perform();
		
		pressedKeyText = pressedKey.getText();
        System.out.println("Pressed key is: " + pressedKeyText);
        
        driver.close();

	}

}
