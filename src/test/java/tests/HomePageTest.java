package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateCompanyPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;	
	NewContactPage newContactPage;
	CreateCompanyPage createCompanyPage;
	
	@Parameters({"username","password"})
	
	@BeforeMethod
	public void initialize(String uname,String pwd) {
		init(); // chrome browser launch and url load
		loginPage = new LoginPage();
		newContactPage = new NewContactPage();
		createCompanyPage = new CreateCompanyPage();
		homePage = loginPage.login(uname,pwd); 
		// it will perform login and return HomePage object
	
	}
	
		@Test
		public void validateLogoutTest() {
			Utility.swithToMainFrame();			
			homePage.logout();	
			boolean logoStatus = loginPage.is_Logo_Displayed(); // true
			Assert.assertTrue(logoStatus);
		}	
		
		@Test
		public void validateRedirectionOfNewContactLink() {
			Utility.swithToMainFrame();
			homePage.clickOnNewContact();
			Assert.assertEquals(newContactPage.getcontactPageTxt(),prop.getProperty("contactPageTxt"));
		}
		
		@Test
		
		public void validateRedirectionOfNewCompanyLink() {
			Utility.swithToMainFrame();
			homePage.clickOnNewCompany();
			Assert.assertEquals(createCompanyPage.getcompanyPageTxt(), prop.getProperty("newCompanyPagetxt"));
		}
		
		
	@AfterMethod
	public void closeResources() {
		driver.close();
	}	
	
}
