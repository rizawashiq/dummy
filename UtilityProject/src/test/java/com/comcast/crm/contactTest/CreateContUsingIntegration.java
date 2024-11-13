package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.fileutility.ExcelUtility;
import com.comcast.crm.objextrepositoryutility.ContactPage;
import com.comcast.crm.objextrepositoryutility.CreateNewContact;
import com.comcast.crm.objextrepositoryutility.CreateNewOrgPage;
import com.comcast.crm.objextrepositoryutility.OrganisationPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.UtilityClassObject;
import com.comcast.crm.webdriverutility.WebDriverUtility;


public class CreateContUsingIntegration extends BaseClass{
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();


	WebDriverUtility wu = new WebDriverUtility();

	@Test(groups = "regression")
	public  void ContactCreate() throws IOException, InterruptedException {

		hm.getOrgbutton().click();
//		UtilityClassObject.getTest().log(Status.INFO, "Org button clicked");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateorgbutton().click();
		String value = eu.getDataFromExcel("org", 3, 2) + ju.getRandomNumber();
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

		Thread.sleep(5000);

		hm.getContactbutton().click();
		ContactPage cg = new ContactPage(driver); 

		cg.getCreateContact().click(); //------------------------------

		String last_name= eu.getDataFromExcel("contact", 3, 2);
		//==========================================================================
		CreateNewContact cc = new CreateNewContact(driver);
		cc.getLastname().sendKeys(last_name);

		String startdate = ju.getDateInYYYYMMDD();
		String enddate = ju.dateAfter("YYYY-MM-dd", 30);

		cc.getStartdate().clear();
		cc.getStartdate().sendKeys(startdate);

		cc.getEnddate().clear();
		cc.getEnddate().sendKeys(enddate);

		// integrating with account
		cc.getOrgintegrate().click();

		wu.switchToNewBrowserWithUrl(driver, "module=Accounts&action");

		//		// change to other driver
		//		Set<String> s = driver.getWindowHandles();
		//		Iterator<String> i = s.iterator();
		//		while(i.hasNext())
		//		{
		//			String page = i.next();
		//			driver.switchTo().window(page);
		//			String ur = driver.getCurrentUrl();
		//			if(ur.contains("module=Accounts&action"))
		//			{
		//				break;
		//			}
		//		}

		cc.getIntegrsearchEdit().sendKeys(value);
//		Assert.assertEquals(value, value);
		cc.getIntegrsearchbtn().click();
		cc.getSelectIntegratedOrg().click();

		wu.switchToNewBrowserWithUrl(driver, "module=Contacts&action");

		cc.getSavebutton().click();

		// validation of value

		
		String actHeader = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
		boolean status =  actHeader.contains(last_name);
		Assert.assertEquals(status, true);
		
		String actLname = driver.findElement(By.id("dtlview_Last Name")).getText() ;
		status = actLname.contains(last_name);
		Assert.assertEquals(status, true);

		
		// validate of start date
		if(driver.findElement(By.id("dtlview_Support Start Date")).getText().equals(startdate))
			System.out.println("The org_name has the value  " +  startdate + " is Pass");
		else
			System.out.println("The org_name has the value  " +  startdate + " is Fail");

		// validate of end date
		if(driver.findElement(By.id("dtlview_Support End Date")).getText().equals(enddate))
			System.out.println("The org_name has the value  " +  enddate + " is Pass");
		else
			System.out.println("The org_name has the value  " +  enddate + " is Fail");
	}
}
