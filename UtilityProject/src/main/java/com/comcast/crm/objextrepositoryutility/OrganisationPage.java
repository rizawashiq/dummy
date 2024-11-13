package com.comcast.crm.objextrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	WebDriver driver;
	
	@FindBy(css = "img[title='Create Organization...']")
	WebElement createorgbutton ;
		
	
	public WebElement getCreateorgbutton() {
		return createorgbutton;
	}

	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
