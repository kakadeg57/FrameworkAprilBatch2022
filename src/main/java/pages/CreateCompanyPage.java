package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateCompanyPage extends TestBase{

		// 1. web elements repository 
		@FindBy(xpath="//*[text()='Create New  Company']")
		WebElement companyPageTxt;
		// 2. actions
			public String getcompanyPageTxt() {
				return companyPageTxt.getText();
			}
		// 3. we will use PageFactory class to initialize web elements
		public	CreateCompanyPage() {
			PageFactory.initElements(driver, this);
		}
}
