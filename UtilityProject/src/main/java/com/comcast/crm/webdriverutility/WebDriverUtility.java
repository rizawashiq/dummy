package com.comcast.crm.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author Mohammed Riza Washiq
 * 
 */
public class WebDriverUtility {

	// implicit waiting for loading
	public void waitToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// explicit waiting for loading
	public void waitForElement(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Switching to windows with url name
	public void switchToNewBrowserWithUrl(WebDriver driver , String partialUrl) {
		Set<String> drivers = driver.getWindowHandles();
		Iterator<String> i = drivers.iterator();

		while(i.hasNext())
		{
			String windows = i.next();
			driver.switchTo().window(windows);
			String url = driver.getCurrentUrl();
			if(url.contains(partialUrl))
				break;
		}	
	}

	// Switching to windows with title name
	public void switchToNewBrowserWithTitle(WebDriver driver , String Title) {
		Set<String> drivers = driver.getWindowHandles();
		Iterator<String> i = drivers.iterator();

		while(i.hasNext())
		{
			String windows = i.next();
			driver.switchTo().window(windows);
			String url = driver.getTitle();
			if(url.contains(Title))
				break;
		}	
	}

	// switchng to frameswith index
	public void switchToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}

	// switchng to frameswith name
	public void switchToFrame(WebDriver driver , String name)
	{
		driver.switchTo().frame(name);
	}

	// switchng to frameswith web element
	public void switchToFrame(WebDriver driver , WebElement element)
	{
		driver.switchTo().frame(element);
	}

	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void selecttheDropDownByText(WebElement element , String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void selecttheDropDownByIndex(WebElement element , int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void moveToElement(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	
	
	
	
	
	




}
