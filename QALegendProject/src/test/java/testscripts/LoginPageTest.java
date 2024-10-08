package testscripts;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Messages;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.automationcore.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import dataprovider.DataProviders;
import pageObject.AddUserPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UserPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class LoginPageTest extends BaseClass{
	@Test(groups={"Smoke","Regression"})
	public void verifyLoginWithValidCredentials()
	{
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		String expectedwelcomemessage = ExcelUtility.getExcelStringData(1, 3, Constants.LOGIN_PAGE);
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		String actualtext = home.getLoginText();
		Assert.assertEquals(actualtext, expectedwelcomemessage , Messages.LOGIN_UNEXPECTEDWELCOMEMESSAGE);
		
		
		
	}
	
	
@Test(dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String username , String userpassword)
	{
	
	String expectederrormessage = ExcelUtility.getExcelStringData(1, 2, Constants.LOGIN_PAGE);
	
	LoginPage login = new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassword(userpassword);
	HomePage home = login.clickOnLoginButton();
	String actualerrormessagewithinvalidlogin = login.errorMessageWithInvalidLogin();
	Assert.assertEquals(actualerrormessagewithinvalidlogin, expectederrormessage, Messages.LOGIN_WITHINVALIDDATA);
	
	
		
	}

}
