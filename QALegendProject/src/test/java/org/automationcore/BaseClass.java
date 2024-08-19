package org.automationcore;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public void initializeBrowser(String Browser)
	{
		if(Browser.equals("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if (Browser.equals("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			throw new RuntimeException("Invalid browser");
		}
		driver.manage().window().maximize();
		driver.get("https://qalegend.com/billing/public/login");
	}
	@BeforeMethod
	public void browserLaunch()
	{
		initializeBrowser("Chrome");
	}
	@AfterMethod
	public void closeBrowser(ITestResult results) throws IOException
	{
		if(results.getStatus() == ITestResult.FAILURE)
		{
			takeScreenShots(results);
		}
		driver.close();
	}
	
	public void takeScreenShots(ITestResult results) throws IOException
	{
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File  screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+results.getName()+".png")); 
		
	}


}
