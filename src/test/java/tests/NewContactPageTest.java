package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class NewContactPageTest extends TestBase

{
	
	LoginPage loginPage;
	HomePage homePage;
	NewContactPage contactPage;
	
	
	@BeforeMethod
	public void initialization() {
		init();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@DataProvider(name = "empData")
	
	public String[][] passData() throws IOException {
		
		String data [][] = Utility.getData();
		return data;
	}
	
	@Test(dataProvider = "empData")
	public void validateNewCreateContactTest(String FN,String LN,String compName,String MobNumber,String add) {
		Utility.swithToMainFrame();
		contactPage = homePage.clickOnNewContact();
		contactPage.createContact(FN, LN, compName, MobNumber, add);
		
	}
	
	
	
	
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
	
	

}
