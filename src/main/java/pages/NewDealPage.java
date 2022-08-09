package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewDealPage extends TestBase {
	//Elements initialization
	
	public NewDealPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Elements repo
	@FindBy(xpath="")
	WebElement element;
	
	//action

}
