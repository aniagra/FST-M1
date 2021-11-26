package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		System.out.println(driver.getTitle());
		
		WebElement chosen = driver.findElement(By.id("multi-value"));
		
		WebElement multiSelect = driver.findElement(By.id("multi-select"));
		
		Select multiSelectDropDown = new Select(multiSelect);
		
		if(multiSelectDropDown.isMultiple())
		{
			
			multiSelectDropDown.selectByVisibleText("Javascript");
			System.out.println(chosen.getText());
			
			multiSelectDropDown.selectByValue("node");
			System.out.println(chosen.getText());
			
			for(int i=4; i<=6; i++) {
				multiSelectDropDown.selectByIndex(i);
            }
            System.out.println(chosen.getText());
            
            multiSelectDropDown.deselectByValue("node");
            System.out.println(chosen.getText());
            
            //Deselect 7th opttion by index
            multiSelectDropDown.deselectByIndex(7);
            System.out.println(chosen.getText());
            
           System.out.println(multiSelectDropDown.getFirstSelectedOption().getText());
           List<WebElement> selectedOptions = multiSelectDropDown.getAllSelectedOptions();
           for(WebElement selectedOption : selectedOptions) {
               System.out.println("Selected option: " + selectedOption.getText());
           }
           
           multiSelectDropDown.deselectAll();
           System.out.println(chosen.getText());
		}
		
		driver.close();
		
		
		

	}

}
