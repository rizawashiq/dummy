package com.comcast.crm.objextrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText = "Organizations")
	WebElement orgbutton ;
	
	@FindBy(linkText = "Contacts")
	WebElement contactbutton ;
	
	
	@FindBy(css = "img[src=\"themes/softed/images/user.PNG\"]")
	WebElement adminicon ;
	
	@FindBy(linkText = "Sign Out")
	WebElement signout ;
	
	
	
	public WebElement getSignout() {
		return signout;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getAdminicon() {
		return adminicon;
	}


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgbutton() {
		return orgbutton;
	}


	public WebElement getContactbutton() {
		return contactbutton;
	}
	
	
	
}		
