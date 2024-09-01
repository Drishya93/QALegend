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
	
	@Test
	
	public void verifyUserCreation()
	{
		
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		//String email = firstname + "." + lastname + "@yahoo.com";
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		//String username = firstname + "@1";
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		//String expectedwelcomemessagefield = "Welcome" + " " + firstname + ",";
		String expectedwelcomemessagefield = Constants.WELCOMEMESSAGE_EXPECTEDPREFIX + " " + firstname + Constants.WELCOMEMESSAGE_EXPECTEDSUFFIX;
		String expectedusername = username;
		
		UserPage user = new UserPage(driver);
		user.verifyUserManagementDropDown();
		user.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		//adduser.verifyRolesDropDown(expectedRole);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		user.verifySearchField(username);
		//user.verifySearchResults();
		String actualusername = user.verifySearchResults();
		Assert.assertEquals(actualusername, expectedusername,Messages.USERCREATION_UNEXPECTEDUSER);
		 
	
		
	
		
	}
		
	
	@Test
		public void verifyLoginWithNewlyAddedUser()
		{
		
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		//String email = firstname + "." + lastname + "@yahoo.com";
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		//String username = firstname + "@1";
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		//String expectedwelcomemessagefield = "Welcome" + " " + firstname + ",";
		String expectedwelcomemessagefield = Constants.WELCOMEMESSAGE_EXPECTEDPREFIX + " " + firstname + Constants.WELCOMEMESSAGE_EXPECTEDSUFFIX;
		String expectedusername = username;
		
		UserPage user = new UserPage(driver);
		user.verifyUserManagementDropDown();
		user.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		//adduser.verifyRolesDropDown(expectedRole);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		user.verifySearchField(username);
		//user.verifySearchResults();
		String actualusername = user.verifySearchResults();
			
			user.clickHomeIcon();
			HomePage home = new HomePage(driver);
			home.clickAdminButton();
			home.clickSignoutButton();
			LoginPage login = new LoginPage(driver);
			login.enterUserName(username);
			login.enterPassword(password1);
			login.clickOnLoginButton();
			String actualwelcomemessage = home.verifyWelcomeMessageAfterUserCreationAndLogin();
			Assert.assertEquals(actualwelcomemessage, expectedwelcomemessagefield , Messages.LOGIN_NEWUSERCREATEDFAILED);
			
	}
	
	@Test
	public void verifyViewUserDetails()
	{
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		//String email = firstname + "." + lastname + "@yahoo.com";
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		String expectedtext = ExcelUtility.getExcelStringData(1, 0, Constants.VIEWUSER_PAGE);
		
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		
		
		UserPage user = new UserPage(driver);
		user.verifyUserManagementDropDown();
		user.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		//adduser.verifyRolesDropDown(expectedRole);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		
		
		user.verifySearchField(username);
		user.verifySearchResults();
		user.verifyViewButton();
		ViewDetailsPage view = new ViewDetailsPage(driver);
		String actualtext = view.verifyViewUserText();
		Assert.assertEquals(actualtext, expectedtext, Messages.MESSAGE_VIEWUSERPAGEMISMATCH);
		
	
	}
	@Test
	
	public void verifyEditUserDetails()
	{
		String prefix = ExcelUtility.getExcelStringData(1, 0, Constants.USERMANAGEMENT_PAGE);
		String expectedRole = ExcelUtility.getExcelStringData(1, 1, Constants.USERMANAGEMENT_PAGE);
		String commission = ExcelUtility.getExcelIntegerData(1, 2, Constants.USERMANAGEMENT_PAGE) ;
		String firstname = RandomDataUtility.getFirstName();
		String lastname = RandomDataUtility.getLastName();
		//String email = firstname + "." + lastname + "@yahoo.com";
		String email = firstname + Constants.EMAIL_RANDOMDATADOT + lastname + Constants.EMAIL_RANDOMDATASUFFIX;
		String username = firstname + Constants.USERNAME_RANDOMDATASUFFIX;
		String password1 = firstname + "." + lastname;
		String confirmpassword = password1;
		String expectedtext = ExcelUtility.getExcelStringData(1, 0, Constants.VIEWUSER_PAGE);
		String first_name = ExcelUtility.getExcelStringData(1, 0, Constants.EDITUSER_PAGE);
		String last_name = ExcelUtility.getExcelStringData(1, 1, Constants.EDITUSER_PAGE);
		
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		
		
		UserPage user = new UserPage(driver);
		user.verifyUserManagementDropDown();
		user.verifyUserDropDown();
		AddUserPage adduser = user.verifyAddUser();
		adduser.verifyPrefixField(prefix);
		adduser.verifyFirstNameField(firstname);
		adduser.verifyLastNameField(lastname);
		adduser.verifyEmailField(email);
		//adduser.verifyRolesDropDown(expectedRole);
		adduser.verifyUserNmaeField(username);
		adduser.verifyPasswordField(password1);
		adduser.verifyConfirmPasswordField(confirmpassword);
		adduser.verifyCommisionField(commission);
		adduser.verifySaveButton(); 
		
		
		user.verifySearchField(username);
		user.verifySearchResults();
		user.verifyeditButton();
		//user.verifyeditButton();
		EditUserPage edit = new EditUserPage(driver);
		edit.editFirstNmae(first_name);
		edit.editLastName(last_name);
		edit.clickUpdateButton();
		user.verifySearchField(first_name);
		String actual_firstname = user.verifySearchResultsafteredit();
		String Expected_firstname = prefix +" "+ first_name + " " + last_name;
		Assert.assertEquals(actual_firstname, Expected_firstname, Messages.MESSAGE_EDITUSERMISMATCH);
		
		
	}
	
}
