package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByIndexFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void verifyMouseRightClick(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public static void verifyMouseDoubleClick(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	public static void verifyMouseHover(WebElement element, WebElement subelement,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).moveToElement(subelement).build().perform();
	}
	
	public static void verifyDragDrop(WebElement draggable, WebElement dropzone, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(draggable).build().perform();
		actions.doubleClick(draggable).build().perform();
		actions.contextClick(draggable).build().perform();
		actions.dragAndDrop(draggable, dropzone).build().perform();
			
	}
	public static void verifyKeyboardEnterKey() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
