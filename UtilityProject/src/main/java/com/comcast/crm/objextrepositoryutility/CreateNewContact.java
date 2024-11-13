package com.comcast.crm.objextrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	WebDriver driver ;
	
	@FindBy(name = "lastname")
	private WebElement lastname ;

	public WebElement getLastname() {
		return lastname;
	}
	
	@FindBy(name = "support_start_date")
		private WebElement startdate ;
	
	@FindBy(name = "support_end_date")
	private WebElement enddate ;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement orgintegrate;

	@FindBy(id = "search_txt")
	private WebElement integrsearchedit;
	
	@FindBy(css = "input[name='search']")
	private WebElement integrsearchbtn;
	
	@FindBy(id = "1")
	private WebElement selectIntegratedOrg ;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement savebutton ;
	
	
	
	public WebElement getSavebutton() {
		return savebutton;
	}



	public WebElement getSelectIntegratedOrg() {
		return selectIntegratedOrg;
	}



	public WebElement getIntegrsearchEdit() {
		return integrsearchedit;
	}


	public WebElement getIntegrsearchbtn() {
		return integrsearchbtn;
	}

	public WebElement getOrgintegrate() {
		return orgintegrate;
	}



	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getStartdate() {
		return startdate;
	}



	public WebElement getEnddate() {
		return enddate;
	}



	public CreateNewContact(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
