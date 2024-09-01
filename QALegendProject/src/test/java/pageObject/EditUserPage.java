package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage {
	WebDriver driver;
	public EditUserPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstnamefield;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement Lastnamefield;
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement updatebutton;
	
	public void editFirstNmae(String first_name)
	{
		firstnamefield.clear();
		firstnamefield.sendKeys(first_name);
	}
	public void editLastName(String last_name)
	{
		Lastnamefield.clear();
		Lastnamefield.sendKeys(last_name);
	}
	public void clickUpdateButton()
	{
		updatebutton.click();
	}

}

