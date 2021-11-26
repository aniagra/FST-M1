package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		System.out.println(driver.getTitle());
		
		List<WebElement> noOfRowsInSortableTable = 
				driver.findElements(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr"));
		
		List<WebElement> noOfColumnsInSortableTable = 
				driver.findElements(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr[1]/td"));
		
		System.out.println(noOfRowsInSortableTable.size());
		System.out.println(noOfColumnsInSortableTable.size());
		
		WebElement cellValue2_2_Before = driver.findElement(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value: " + cellValue2_2_Before.getText());
        
        WebElement headerOfFirstCol = driver.findElement(By.xpath("//table[@id ='sortableTable']/thead/tr/th[2]"));
        headerOfFirstCol.click();//table[@id='sortableTable']/thead/tr/th[2]
        WebElement cellValue2_2_After = driver.findElement(By.xpath("//table[@id ='sortableTable']/tbody/tr[2]/td[2]"));
        
        System.out.println("Second row, second column value: " + cellValue2_2_After.getText());
        
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id ='sortableTable']/tfoot/tr[1]/th"));
        for(WebElement foot: footer)
        {
        	System.out.println(foot.getText());
        }
        
        driver.close();

	}

}
