package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewTaskPage;
import util.Utility;

public class NewTaskPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	NewTaskPage taskPage;
	
	
	@BeforeMethod
	public void initialization() {
		init();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@DataProvider(name= "taskData")
	
	public String[][] passTaskData() throws IOException {
		String dataa[][] = Utility.getDataaa();
		return dataa;
	}
	
	@Test(dataProvider= "taskData")
	public void validateNewDealPageTest(String T, String C, String D, String ta, String I ) {
     Utility.swithToMainFrame();
     taskPage=homePage.newTaskPage();
     taskPage.newTaskPage(T, C, D, ta, I);
     }
	
	@AfterMethod
	public void closeResources () {
		driver.close();
	}

}
