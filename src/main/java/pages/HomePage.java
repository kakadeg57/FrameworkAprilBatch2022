package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import util.Utility;

public class HomePage extends TestBase{
	
	
	// 1. web elements repository 
	@FindBy (xpath = "//*[contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	@FindBy (xpath = "//a[text()='Contacts']")
	WebElement contacts;
	
	@FindBy (xpath = "//a[text()='New Contact']")
	WebElement createContactLink;
	
	
	@FindBy (xpath = "//a[text()='Companies']")
	WebElement company;
	
	@FindBy (xpath = "//a[text()='New Company']")
	WebElement creatCompanyLink;
	
	@FindBy(xpath="//*[text()='Tasks']")
	WebElement task;
	
	@FindBy(xpath="//*[text()='New Task']")
	WebElement NewTaskPageLink;
		
	//2. actions
	public void logout() {
		logoutBtn.click();
	}
	
	public NewContactPage clickOnNewContact() {
		Utility.mouseOver(contacts);
		createContactLink.click();
		return new NewContactPage();
	}
	
	public void clickOnNewCompany() {
		Utility.mouseOver(company);
		creatCompanyLink.click();
	}
	
	// deal
	public NewTaskPage newTaskPage () {
		Utility.mouseOver(task);
		NewTaskPageLink.click();
		return new NewTaskPage();
	}
	
	// task
	
	//3. we will use PageFactory class to initialize web elements

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
