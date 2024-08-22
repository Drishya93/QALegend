package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginbutton;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement Forgotpasswordbutton;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement sendpasswordrestlink;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement errormessagewhenloginusinginvalidcredentials;
	
	
	
	public void enterUserName(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	public HomePage clickOnLoginButton()
	{
		loginbutton.click();
		return new HomePage(driver);
	}
	
	public String errorMessageWithInvalidLogin()
	{
		return errormessagewhenloginusinginvalidcredentials.getText();
	}
	
	public ForgotPasswordPage forgotPasswordButton()
	{
		Forgotpasswordbutton.click();
		return new ForgotPasswordPage(driver);
	}
	
	
}

		
	


