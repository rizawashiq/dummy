package com.comcast.crm.organisationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.fileutility.ExcelUtility;
import com.comcast.crm.fileutility.FileUtility;
import com.comcast.crm.objextrepositoryutility.CreateNewOrgPage;
import com.comcast.crm.objextrepositoryutility.HomePage;
import com.comcast.crm.objextrepositoryutility.LoginPage;
import com.comcast.crm.objextrepositoryutility.OrganisationPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;



public class CreateOrgWIthPhone extends BaseClass{
	
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();
	
	/*
	 * 
	*/
	WebDriverUtility wu = new WebDriverUtility();
	
	@Test(groups = "regression")
	public void createContact() throws IOException, InterruptedException{
		
		
		hm.getOrgbutton().click();
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateorgbutton().click();
		String value = eu.getDataFromExcel("org", 4, 2) + ju.getRandomNumber();
		CreateNewOrgPage cnp = new CreateNewOrgPage(driver);
		cnp.getName().sendKeys(value );
		
		String industry = eu.getDataFromExcel("org", 4, 3);
		wu.selecttheDropDownByText(cnp.getIndustry() , industry);
		
		
		Select s1 = new Select(cnp.getType());
		String type =  eu.getDataFromExcel("org", 4, 4);
		s1.selectByVisibleText(type);
		
		String num =   eu.getDataFromExcel("org", 4, 5).trim();
		cnp.getPhone().sendKeys(num);
		
		cnp.getSave().click();
		
		
		if(driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText().contains(value))
			System.out.println("The org_name has the value  " +  value + " is Pass");
		else
			System.out.println("The org_name has the value  " +  value + " is Fail");
		
		if(driver.findElement(By.id("dtlview_Organization Name")).getText().contains(value))
			System.out.println("The org_name has the value  " +  value + " is Pass");
		else
			System.out.println("The org_name has the value  " +  value + " is Fail");
		
		// validation of industry
		if(driver.findElement(By.id("dtlview_Industry")).getText().equals(industry))
			System.out.println("The industry  has the value  " +  industry + " is Pass");
		else
			System.out.println("The industry has the value  " +  industry + " is Fail");	
		
		// Validation of type
		if(driver.findElement(By.id("dtlview_Type")).getText().equals(type))
			System.out.println("The type  has the value  " +  type + " is Pass");
		else
			System.out.println("The type has the value  " +  type + " is Fail");	
		
		// validation of number
		if(driver.findElement(By.id("dtlview_Phone")).getText().trim().equals(num))
			System.out.println("The num  has the value  " +  num + " is Pass");
		else
			System.out.println("The num has the value  " +  num + " is Fail");	
		
		
	}
}
