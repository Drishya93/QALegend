package testscripts;

import org.automationcore.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Messages;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends BaseClass {
	@Test
	
	public void verifyUserLoginDate()
	{
		String user_name = ExcelUtility.getExcelStringData(1, 0, Constants.LOGIN_PAGE);
		String pasword = ExcelUtility.getExcelIntegerData(1, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(user_name);
		login.enterPassword(pasword);
		HomePage home = login.clickOnLoginButton();
		home.clickEndTourButton();
		String homepagedate = home.getLoginDate();
		String currentdate = home.getCurrentDate();
		Assert.assertEquals(homepagedate, currentdate, Messages.MESSAGE_DATEMISMATCH);
	}
	

}
