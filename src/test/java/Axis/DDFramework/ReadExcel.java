package Axis.DDFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
  @Test
  public void FaceBookLogin() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91630\\Documents\\NewChromeDriver\\chromedriver-win64\\chromedriver-win64/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		File src= new File("C:\\Users\\91630\\eclipse-workspace\\TestData.xlsx");
		FileInputStream fis= new FileInputStream(src);
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
        
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
          
			cell = sheet.getRow(i).getCell(0);        
          
		  driver.findElement(By.xpath("//input[@name = 'email']")).clear();
          driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(cell.getStringCellValue());
          
          cell = sheet.getRow(i).getCell(1);  
          driver.findElement(By.xpath("//input[@id='pass']")).clear();
          driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(cell.getStringCellValue());
 
		}
  }

}