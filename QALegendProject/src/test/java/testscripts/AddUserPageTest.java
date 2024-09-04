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

import constants.Constants;
import constants.Messages;
import pageObject.AddUserPage;
import pageObject.EditUserPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UserPage;
import pageObject.ViewDetailsPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends BaseClass{
	
	@Test(groups={"Smoke","Regression"})
	
	public void verifyUserCreation()
	{
		
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		String expectedwelcomemessagefield = Constants.WELCOMEMESSAGE_EXPECTEDPREFIX + " " + firstname + Constants.WELCOMEMESSAGE_EXPECTEDSUFFIX;
		String expectedusername = username;
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		UserPage user = new UserPage(driver);
		home.verifyUserManagementDropDown();
		home.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		user.verifySearchField(username);
		String actualusername = user.verifySearchResults();
		Assert.assertEquals(actualusername, expectedusername,Messages.USERCREATION_UNEXPECTEDUSERNAME);
		 
	
		
	
		
	}
		
	
	@Test(groups="Regression")
		public void verifyLoginWithNewlyAddedUser()
		{
		
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		String expectedwelcomemessagefield = Constants.WELCOMEMESSAGE_EXPECTEDPREFIX + " " + firstname + Constants.WELCOMEMESSAGE_EXPECTEDSUFFIX;
		String expectedusername = username;
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		UserPage user = new UserPage(driver);
		home.verifyUserManagementDropDown();
		home.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		user.clickHomeIcon();
		home.clickAdminButton();
		home.clickSignoutButton();
		login.enterUserName(username);
		login.enterPassword(password1);
		login.clickOnLoginButton();
		String actualwelcomemessage = home.verifyWelcomeMessageAfterUserCreationAndLogin();
		Assert.assertEquals(actualwelcomemessage, expectedwelcomemessagefield , Messages.LOGIN_NEWUSERCREATEDFAILED);
			
	}
	
	
	
}
