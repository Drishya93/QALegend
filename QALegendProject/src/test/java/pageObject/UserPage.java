package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver driver;
	public UserPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchButton;
	@FindBy(xpath="//table[@id='users_table']/tbody/tr[1]/td[1]")
	WebElement usernameintable;
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;
	@FindBy(xpath="//i[@class='fa fa-dashboard']")
	WebElement homeicon;
	@FindBy(xpath="//a[@class='btn btn-xs btn-info']")
	WebElement viewbutton;
	@FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
	WebElement editbutton;
	@FindBy(xpath="//table[@id='users_table']/tbody/tr[1]/td[2]")
	WebElement firstnameintable;
	
	
	
	public void verifySearchField(String username)
	{
		SearchButton.sendKeys(username);
	}
	public String verifySearchResults()
	{
		String name = usernameintable.getText();
		return name;
	}
	public AddUserPage verifyAddUser()
	{
		addbutton.click();
		return new AddUserPage(driver);
	}
	public HomePage clickHomeIcon()
	{
		homeicon.click();
		return new HomePage(driver);
	}
	public ViewDetailsPage verifyViewButton()
	{
		 viewbutton.click();
		 return new ViewDetailsPage(driver);
	}
	public EditUserPage verifyeditButton()
	{
		editbutton.click();
		return new EditUserPage(driver);
	}
	public String verifySearchResultsafteredit()
	{
		String firstname = firstnameintable.getText();
		return firstname;
	}

}
