package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class WaitUtility {
	
	WebDriver driver;
	
	
	
public static void waitForAnElement(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLYWAIT));
	}
	
public static void waitForAnElementToBeClickable(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public static void waitForAnElementToBeSelected(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}

public static void waitForVisibilityOf(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static void waitElementInvisibility(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.invisibilityOf(element));
}
public static void waitElementSelectionStateToBe(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
}

public static void waitForAFrameToBeAvailable(WebDriver driver , WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICITLYWAIT));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
}
public static void waitForAnElementFrequentExecution(WebDriver driver , WebElement element)
{
	FluentWait fluentwait = new FluentWait(driver);
	fluentwait.withTimeout(Duration.ofSeconds(Constants.FLUENTWAIT));
	fluentwait.pollingEvery(Duration.ofSeconds(Constants.FLUENTWAIT));
	fluentwait.ignoring(NoSuchElementException.class);	
	fluentwait.until(ExpectedConditions.elementToBeClickable(element));
}
}
