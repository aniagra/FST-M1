package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		System.out.println(driver.getTitle());
		
		WebElement selectedValue = driver.findElement(By.id("single-value"));
		
		WebElement dropdown = driver.findElement(By.id("single-select"));
		Select dropdownValue = new Select(dropdown);
		dropdownValue.selectByVisibleText("Option 2");
		System.out.println(selectedValue.getText());
		
		dropdownValue.selectByIndex(3);
		System.out.println(selectedValue.getText());
		
		dropdownValue.selectByValue("4");
		System.out.println(selectedValue.getText());
		
		List<WebElement> allOptions = dropdownValue.getOptions();
		for(WebElement option: allOptions)
		{
			System.out.println(option.getText());
		}
		
		List<WebElement> allSelectedOptions = dropdownValue.getAllSelectedOptions();
		for(WebElement option: allSelectedOptions)
		{
			System.out.println(option.getText());
		}
		
		driver.close();

	}

}
