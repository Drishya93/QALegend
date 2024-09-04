package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class UserProfilePage {
	WebDriver driver;
	public UserProfilePage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updatebutton;
	@FindBy(xpath="//div[text()='Profile updated successfully']")
	WebElement updationpopup;
	
	
	
	
	public void verifyEmailField(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
	}

	public void verifyUpdateButton()
	{
		updatebutton.click();
	}
	
	public boolean isUserProfileUpdatePromptVisible()
	{
		return updationpopup.isDisplayed();
	}
}
