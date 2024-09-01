package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UserProfilePage {
	WebDriver driver;
	public UserProfilePage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profilebutton ;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updatebutton;
	
	
	public void verifyProfileButton()
	{
		profilebutton.click();
	}
	
	public void verifyEmailField(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
	}

	public void verifyUpdateButton()
	{
		updatebutton.click();
	}
	
	public String  verifyTextInEmailField()
	{
		emailfield.click();
		WaitUtility.waitForAnElementToBeClickable(driver,emailfield);
		return emailfield.getText();
	}
}
