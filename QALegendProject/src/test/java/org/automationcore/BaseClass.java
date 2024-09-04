package org.automationcore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

import constants.Constants;
import utilities.WaitUtility;

public class BaseClass {
	public WebDriver driver;
	public FileInputStream file;
	public Properties property;
	public void initializeBrowser(String Browser) 
	{
		property = new Properties();
		try {
			file = new FileInputStream(Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		driver.get(property.getProperty("url"));
		WaitUtility.waitForAnElement(driver);
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
