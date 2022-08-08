package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class Utility extends TestBase{
	
	
	public static void swithToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void mouseOver(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}
	
	// dropdown
	public static void selectDropDown(WebElement element,String dropDownName) {
		Select sel = new Select(element);
		sel.selectByVisibleText(dropDownName);
	}

	
	public static String[][] getData() throws IOException {
		
		
		FileInputStream file =  new FileInputStream("D:\\SoftWare Testing\\AutoMation Testing\\TestData\\EmpData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheet("data");
			
		int rows = sheet.getLastRowNum();	
		int column = sheet.getRow(0).getLastCellNum();
		String empData [][] = new String [rows][column];
		for(int i = 0;i<rows;i++) // rows
		{
			for (int j=0;j<column;j++) // columns
			{
				 empData  [i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}	
		return  empData ;
	}
}
