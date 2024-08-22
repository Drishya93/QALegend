package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement forgotpasswordemail;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement sendpasswordresetlinkbutton;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement promptmessage;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement promptmessageforinvalidemailid;
	
	public void verifyForgotPasswordEmail(String emailid)
	{
		forgotpasswordemail.sendKeys(emailid);
	}
	
	public void verifySendPasswordResetLinkButton()
	{
		sendpasswordresetlinkbutton.click();
	}
	
	public String verifyPromptMessageForPasswordReset()
	{
		String actualtext =  promptmessage.getText();
		return actualtext;
	}
	
	public String verifyPromptMessageForPasswordResetWithInvalidEmail()
	{
		String actualtextforinvalidcase =  promptmessageforinvalidemailid.getText();
		return actualtextforinvalidcase;
	}
}
