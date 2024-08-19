package testscripts;
import static org.testng.Assert.assertEquals;

import org.automationcore.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass{
	@Test
	public void verifyLoginWithValidCredentials()
	{
		String user_name = ExcelUtility.getExcelStringData(1, 0, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(user_name);
		
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, "LoginPage");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(pasword);
		
		WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login.click();
		WebElement welcomemessage = driver.findElement(By.xpath("//section[@class='content-header']"));
		String actualwelcomemessage = welcomemessage.getText();
		String expectedwelcomemessage = ExcelUtility.getExcelStringData(1, 3, "LoginPage");
		Assert.assertEquals(actualwelcomemessage, expectedwelcomemessage, "Succesful Login");
			
	}
@Test(dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String username , String userpassword)
	{
	WebElement user_name = driver.findElement(By.xpath("//input[@id='username']"));
	user_name.sendKeys(username);
	WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys(userpassword);
	WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	login.click();
	WebElement actualerror = driver.findElement(By.xpath("//span[@class='help-block']"));
	String actualerrormessage = actualerror.getText();
	String expectederrormessage = ExcelUtility.getExcelStringData(1, 2, "LoginPage");
	Assert.assertEquals(actualerrormessage, expectederrormessage, "Not Expected Prompt");
		
	}

}
