package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	
	
	// 1. web elements repository 
		// username text box
		@FindBy(name = "username") 
		WebElement usernameTxtBox;
	
		// password text box
		@FindBy (css = "[placeholder='Password']")	
		WebElement passwordTxtBox;
		// login button
		@FindBy (xpath = "//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy (className="img-responsive")
		WebElement logoImg;
		
		@FindBy (xpath = "//td[contains(text(),'GANESH KAKADE')]")
		WebElement userID;
	
		// int empID = 2022;
		// WebElement usernameTxtBox = driver.findElement (By.name("value"));
		// usernameTxtBox.sendKeys("username");
		
		
		
	
	//2. actions 
		
		public HomePage login(String username,String password) {
			usernameTxtBox.sendKeys(username);
			passwordTxtBox.sendKeys(password);
			loginBtn.click();
			HomePage abc = new HomePage();
			return abc;
		}
		
		
		
		public String getUserID() {
			return userID.getText();
		}
	
		public boolean is_Logo_Displayed() {
			return	logoImg.isDisplayed();
		}
	
		
		//3. we will use PageFactory class to initialize web elements
		
				public LoginPage() 
				{
					PageFactory.initElements(driver, this);
				}
	

}
