package com.comcast.crm.objextrepositoryutility;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
	
	WebDriver driver;

	@FindBy(xpath = "//input[@name='accountname']")
	WebElement name ;
	
	@FindBy(id = "phone")
	WebElement phone ;
	
	@FindBy(name = "industry")
	WebElement industry ;
	
	@FindBy(name = "accounttype")
	WebElement type;
	
	@FindBy(xpath = "//input[@type='button']")
	WebElement save ;
	


	public CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getSave() {
		return save;
	}
	
	
	
}
