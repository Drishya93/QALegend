package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement prefixfield;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstnamefield;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastnamefield;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath="//ul[@id='select2-role-results']")
	WebElement roledropdown;
	@FindBy(xpath="//input[@id='username']")
	WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordfield;
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmpasswordfield;
	@FindBy(xpath="//input[@id='cmmsn_percent']")
	WebElement commisionfield;
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement savebutton;
	
	
	public void verifyPrefixField(String prefix)
	{
		prefixfield.sendKeys(prefix);
	}
	public void verifyFirstNameField(String firstname)
	{
		firstnamefield.sendKeys(firstname);
	}
	public void verifyLastNameField(String lastname)
	{
		lastnamefield.sendKeys(lastname);
	}
	public void verifyEmailField(String email)
	{
		emailfield.sendKeys(email);
	}
	public void verifyUserNmaeField(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void verifyPasswordField(String password)
	{
		passwordfield.sendKeys(password);
	}
	public void verifyConfirmPasswordField(String confirmpassword)
	{
		confirmpasswordfield.sendKeys(confirmpassword);
	}
	public void verifyCommisionField(String commision)
	{
		commisionfield.sendKeys(commision);
	}
	public UserPage verifySaveButton()
	{
		savebutton.click();
		return new UserPage(driver);
	}
	
	
	
}
