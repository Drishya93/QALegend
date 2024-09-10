package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.DateUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement loginname;
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtourbutton;
	@FindBy(xpath="//span[text()='Admin ']")
	WebElement adminbutton;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signoutbutton;
	@FindBy(xpath="//section[@class='content-header']")
	WebElement actualwelcomemessagefieldafterloginwithcreateduser;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement logindatefield;
	@FindBy(xpath="//span[@class='pull-right-container']")
	WebElement usermanagementdropdown;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement users;
	
	
	public String getLoginText()
	{
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement loginElement = wait.until(ExpectedConditions.visibilityOf(loginname));
	   String logintext = loginname.getText();
	   return logintext;
	
	}
	public void clickEndTourButton()
	{
		endtourbutton.click();
	}
	public void clickAdminButton()
	{
		adminbutton.click();
	}
	
	public LoginPage clickSignoutButton()
	{
		signoutbutton.click();
		return new LoginPage(driver);
	}
	public String verifyWelcomeMessageAfterUserCreationAndLogin()
	{
		String actualmessage = actualwelcomemessagefieldafterloginwithcreateduser.getText();
		return actualmessage;
	}
	public String getLoginDate()
	{
		String logindate = logindatefield.getText();
		return logindate;
	}
	public String getCurrentDate()
	{
		return DateUtility.getUserLoginDate(Constants.CURRENT_DATE);
	}
	public void verifyUserManagementDropDown()
	{
		usermanagementdropdown.click();
	}
	public void verifyUserDropDown()
	{
		users.click();
	}

}
