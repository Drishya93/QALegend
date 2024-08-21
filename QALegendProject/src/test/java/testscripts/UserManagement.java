package testscripts;

import java.time.Duration;
import java.util.List;

import org.automationcore.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserManagement extends BaseClass{
	
	@Test
	
	public void verifyUserCreation()
	{
		WebElement usermanagementdropdown = driver.findElement(By.xpath("//span[@class='pull-right-container']"));
		usermanagementdropdown.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated syntax
		WebElement users = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")));
		users.click();
		WebElement add = driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		add.click();
		WebElement prefixfield = driver.findElement(By.xpath("//input[@id='surname']"));
		String prefix = ExcelUtility.getExcelStringData(1, 0, "UserManagementPage");
		prefixfield.sendKeys(prefix);
		WebElement firstnamefield = driver.findElement(By.xpath("//input[@id='first_name']"));
		String firstname = RandomDataUtility.getFirstName();
		firstnamefield.sendKeys(firstname);
		WebElement lastnamefield = driver.findElement(By.xpath("//input[@id='last_name']"));
		String lastname = RandomDataUtility.getLastName();
		lastnamefield.sendKeys(lastname);
		WebElement emailfield = driver.findElement(By.xpath("//input[@id='email']"));
		String email = firstname + "." + lastname + "@yahoo.com";
		emailfield.sendKeys(email);
		
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, "UserManagementPage"); 
		WebElement roledropdown = driver.findElement(By.xpath("//span[@id='select2-role-container']"));
		roledropdown.click();

		
		List<WebElement> rolelist = driver.findElements(By.xpath("//li[@class='select2-results__option']"));

		for (int i = 0; i < rolelist.size(); i++) {
		    if (rolelist.get(i).getText().equals(expectedRole)) {
		        rolelist.get(i).click();
		        break;
		    }
		}
		
		
		WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		String username = firstname + "@1";
		usernamefield.sendKeys(username);
		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		String password1 = firstname + "." + lastname;
		passwordfield.sendKeys(password1);
		WebElement confirmpasswordfield = driver.findElement(By.xpath("//input[@id='confirm_password']"));
		String confirmpassword = password1;
		confirmpasswordfield.sendKeys(confirmpassword);
		WebElement commisionfield = driver.findElement(By.xpath("//input[@id='cmmsn_percent']"));
		String commission = ExcelUtility.getExcelIntegerData(1, 2, "UserManagementPage") ;
		commisionfield.sendKeys(commission);
		
		WebElement savebutton = driver.findElement(By.xpath("//button[@id='submit_user_button']"));
		savebutton.click();
	
	WebElement SearchButton = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	SearchButton.sendKeys(username);
	//WebElement usernameintable = driver.findElement(By.xpath("//table[@id='users_table']/tbody/tr[1]/td[1]"));
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement usernameintable= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='users_table']/tbody/tr[1]/td[1]")));
	String usernametologin = usernameintable.getText();
	System.out.println(usernametologin);
	
	
	WebElement admin = driver.findElement(By.xpath("//span[text()='Admin ']"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", admin);
	
	WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
	signout.click();
	WebElement usernameaftercreated = driver.findElement(By.xpath("//input[@id='username']"));
	usernameaftercreated.sendKeys(usernametologin);
	
	
	WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys(password1);
	
	WebElement login1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	login1.click();
	
	WebElement actualwelcomemessagefield = driver.findElement(By.xpath("//section[@class='content-header']"));
	String actualwelcometag = actualwelcomemessagefield.getText();
	
	String expectedwelcomemessagefield = "Welcome" + " " + firstname + ",";
	
	Assert.assertEquals(actualwelcometag, expectedwelcomemessagefield, "Login Failed");
	
	}
	
}
