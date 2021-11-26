package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println(driver.getTitle());
		
		WebElement username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
		WebElement confirmPassword = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement confirmPWD = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
		
		WebElement email = driver.findElement(By.xpath("//input[starts-with(@class,'email')]"));
		WebElement mail = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
		
		username.sendKeys("anisha");
		password.sendKeys("12345");
		confirmPWD.sendKeys("12345");
		mail.sendKeys("abc@test.com");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
		
		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
		
		driver.close();
		
		

	}

}
