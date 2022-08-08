package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewContactPage extends TestBase{
	
	// elements repo
	
	@FindBy (xpath ="//*[text()='Contact Information']")
	WebElement contactPageTxt;
	
	
	// to create contact WebElements
	@FindBy	(id = "first_name")
	WebElement firstNameTxtBox;
	@FindBy(id = "surname")
	WebElement lastNameTxtBox;
	@FindBy(name = "client_lookup")
	WebElement companyNameTxtBox;
	@FindBy(id = "mobile")
	WebElement mobileNumberTxtBox;
	@FindBy(name = "address")
	WebElement addressTxtBox;
	@FindBy(xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	

	
	// action
	
	public String getcontactPageTxt() {
		String txt = contactPageTxt.getText();
		return txt;
	}
	
	public void createContact(String FN, String LN,String compName,String mobile,String add) {
		firstNameTxtBox.sendKeys(FN);
		lastNameTxtBox.sendKeys(LN);
		companyNameTxtBox.sendKeys(compName);
		mobileNumberTxtBox.sendKeys(mobile);
		addressTxtBox.sendKeys(add);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
}
