package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import util.Utility;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void initialization () {		
		init();
		loginPage = new LoginPage();
	}
	
	
	
	@Test
	public void validateLoginTest() {
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
			Utility.swithToMainFrame();
		
			String userName = loginPage.getUserID();
			
			System.out.println(userName);
			
			Assert.assertEquals(userName, "  User: Admin");
		}
	
	@Test
	public void validateLogoTest() {
	boolean logoStatus =	loginPage.is_Logo_Displayed();
		Assert.assertEquals(logoStatus, true);
	}
	
		// validateTitleTest
		// validateLinks
		// validateForgotPassword
		
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
	
	
	
	
	
	

}
