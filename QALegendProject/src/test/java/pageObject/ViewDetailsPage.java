package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDetailsPage {
	WebDriver driver;
	public ViewDetailsPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath="//h1[text()='View User']")
	WebElement viewusertext;
	
	public String verifyViewUserText()
	{
		return viewusertext.getText();
	}

}
