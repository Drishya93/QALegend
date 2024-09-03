package testscripts;

import org.automationcore.BaseClass;
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

public class UserPageTest extends BaseClass{
	@Test(groups="Sanity")
	public void verifyViewUserDetails()
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
	@Test(groups="Sanity")
	
	public void verifyEditUserDetails()
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
		Assert.assertEquals(actual_firstname, Expected_firstname, Messages.MESSAGE_EDITUSERFAILED);
		
		
	}

}
