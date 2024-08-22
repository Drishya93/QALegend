package testscripts;

import org.automationcore.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;
import utilities.ExcelUtility;

public class PasswordResetPageTest extends BaseClass{
	@Test
	public void verifyPasswordResetWithValidEmail()
	{
		String emailaddress = ExcelUtility.getExcelStringData(1, 0, "PasswordResetPage");
		String expectederrormessage = ExcelUtility.getExcelStringData(1, 3, "PasswordResetPage");
		
		LoginPage login = new LoginPage(driver);
		ForgotPasswordPage forgotpassword = login.forgotPasswordButton();
		forgotpassword.verifyForgotPasswordEmail(emailaddress);
		forgotpassword.verifySendPasswordResetLinkButton();
		forgotpassword.verifyPromptMessageForPasswordReset();
		String actualmessage = forgotpassword.verifyPromptMessageForPasswordReset();
		Assert.assertEquals(actualmessage, expectederrormessage, "Password Reset Failed");
		
	}
		
	@Test
	
	public void verifyPasswordResetWithInvalidEmail()
	{
		String expectederrormessage = ExcelUtility.getExcelStringData(1, 2, "PasswordResetPage");
		String emailaddress = ExcelUtility.getExcelStringData(1, 1, "PasswordResetPage");
		
		LoginPage login = new LoginPage(driver);
		ForgotPasswordPage forgotpassword = login.forgotPasswordButton();
		forgotpassword.verifyForgotPasswordEmail(emailaddress);
		forgotpassword.verifySendPasswordResetLinkButton();
		forgotpassword.verifyPromptMessageForPasswordResetWithInvalidEmail();
		String actualmessage = forgotpassword.verifyPromptMessageForPasswordResetWithInvalidEmail();
		Assert.assertEquals(actualmessage, expectederrormessage, "Password Reset Failed");
		
		
	}

}
