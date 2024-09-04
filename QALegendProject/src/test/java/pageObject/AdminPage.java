package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profilebutton ;
	
	public UserProfilePage verifyProfileButton()
	{
		profilebutton.click();
		return new UserProfilePage(driver);
	}

}
