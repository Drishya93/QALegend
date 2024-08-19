package testscripts;

import org.automationcore.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class PasswordResetPageTest extends BaseClass{
	@Test
	public void verifyPasswordResetWithValidEmail()
	{
		WebElement forgotpassword = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotpassword.click();
		String emailaddress = ExcelUtility.getExcelStringData(1, 0, "PasswordResetPage");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(emailaddress);
		WebElement sendpasswordresetlink = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		sendpasswordresetlink.click();
		WebElement errormessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String actualerrormessage = errormessage.getText();
		String expectederrormessage = ExcelUtility.getExcelStringData(1, 3, "PasswordResetPage");
		Assert.assertEquals(actualerrormessage, expectederrormessage, "Password Reset Failed");
	}
	@Test
	
	public void verifyPasswordResetWithInvalidEmail()
	{
		WebElement forgotpassword = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotpassword.click();
		String emailaddress = ExcelUtility.getExcelStringData(1, 1, "PasswordResetPage");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(emailaddress);
		WebElement sendpasswordresetlink = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		sendpasswordresetlink.click();
		WebElement errormessage = driver.findElement(By.xpath("//span[@class='help-block']"));
		String actualerrormessage = errormessage.getText();
		String expectederrormessage = ExcelUtility.getExcelStringData(1, 2, "PasswordResetPage");
		Assert.assertEquals(actualerrormessage, expectederrormessage, "Password Reset Failed");
	}

}
