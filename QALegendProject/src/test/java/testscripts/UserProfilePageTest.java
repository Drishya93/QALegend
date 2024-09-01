package testscripts;

import org.automationcore.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Messages;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UserPage;
import pageObject.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserProfilePageTest extends BaseClass{
	@Test
	
	public void verifyUserProfileTest()
	{

	String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
	String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
	String emailid = RandomDataUtility.getEmailid();
	LoginPage login = new LoginPage(driver);
	login.enterUserName(user_name);
	login.enterPassword(pasword);
	HomePage home = login.clickOnLoginButton();
	home.clickEndTourButton();
	UserPage user = new UserPage(driver);
	user.clickHomeIcon();
	home.clickAdminButton();
	UserProfilePage profilepage = new UserProfilePage(driver);
	profilepage.verifyProfileButton();
	profilepage.verifyEmailField(emailid);
	profilepage.verifyUpdateButton();
	user.clickHomeIcon();
	home.clickAdminButton();
	profilepage.verifyProfileButton();
	String Expected_emailid = emailid;
	String Actual_emailid = profilepage.verifyTextInEmailField();
	Assert.assertEquals(Actual_emailid, Expected_emailid, Messages.MESSAGE_EMAILIDMISMATCH);
	
	}

}
