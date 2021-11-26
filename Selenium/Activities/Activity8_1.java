package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		System.out.println(driver.getTitle());
		
		List<WebElement> noOfRows = 
				driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
		List<WebElement> noOfColumns = 
				driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
		
		List<WebElement> noOfRowsInSortableTable = 
				driver.findElements(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr"));
		
		List<WebElement> noOfColumnsInSortableTable = 
				driver.findElements(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr[1]/td"));
		
		System.out.println(noOfRows.size());
		System.out.println(noOfColumns.size());
		System.out.println(noOfRowsInSortableTable.size());
		System.out.println(noOfColumnsInSortableTable.size());
		
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
		for(WebElement thirdCellValue: thirdRow)
		{
			System.out.println("Cell Value: " + thirdCellValue.getText());
		}
		
		WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value: " + cellValue2_2.getText());
        
        driver.close();

	}

}
