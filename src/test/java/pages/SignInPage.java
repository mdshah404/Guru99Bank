package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testsScripts.Base;

public class SignInPage extends Base{
	
	WebDriver driver;
	
	@FindBy(xpath = "//label[@id='message23']") 	WebElement uid;
	@FindBy(xpath = "//input[@name='password']")	WebElement pass;
	@FindBy(xpath = "//input[@name='btnLogin']") 	WebElement loginButton;
	
	public SignInPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
