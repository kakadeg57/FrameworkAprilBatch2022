package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewTaskPage extends TestBase {
	
	// 1. WebElements repository
	@FindBy(id="//*[@id='title']")
	WebElement TitleTxtBox;
	
	@FindBy(id="//*[@id='completion']")
	WebElement Completion;
	
	@FindBy(name="//*[@name=\'prospect_lookup\']")
	WebElement DealTxtBox;
	
	@FindBy(id="//*[@id=\'tags\']")
	WebElement TagsTxtBox;
	
	@FindBy(name="//*[@name=\'identifier\']")
	WebElement IdentifierTxtBox;
	
	@FindBy(xpath="//*[@id=\"taskForm\"]/table/tbody/tr[1]/td/input")
	WebElement saveBtn;
	
	
	

	//2 Initialization web elements
	public NewTaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	//2 Actions
	
	public void newTaskPage(String T, String C, String D, String ta, String I) {
		TitleTxtBox.sendKeys("");
		Completion.sendKeys("");
		DealTxtBox.sendKeys("");
		TagsTxtBox.sendKeys("");
		IdentifierTxtBox.sendKeys("");
		saveBtn.click();
		
	}
}
