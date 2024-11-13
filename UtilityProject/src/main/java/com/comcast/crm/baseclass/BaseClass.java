package com.comcast.crm.baseclass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.comcast.crm.fileutility.FileUtility;
import com.comcast.crm.objextrepositoryutility.HomePage;
import com.comcast.crm.objextrepositoryutility.LoginPage;
import com.comcast.crm.webdriverutility.UtilityClassObject;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver ;
	public HomePage hm;
	public static WebDriver edriver ;
	
//	@Parameters("Browser")
	@BeforeClass(groups = {"regression","smoke"})
	//public void launchBrowser(String  Browser) throws IOException
	public void launchBrowser() throws IOException {
		FileUtility fu = new FileUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		String browser = fu.getDataFromPropertyFile("browser");
//		String browser = Browser ;
		
		String url = fu.getDataFromPropertyFile("url");

		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
//		 edriver = driver ; 
		
//		UtilityClassObject.setTest().
		 UtilityClassObject.setDriver(driver);
		 
		driver.get(url);
		driver.manage().window().maximize();
		wdu.waitToLoad(driver);
		hm = new HomePage(driver);
	}
	
	
	@BeforeMethod(groups = {"regression","smoke"})
	public void login() throws IOException
	{
		FileUtility fu = new FileUtility();
		
		String un = fu.getDataFromPropertyFile("un");
		String pwd = fu.getDataFromPropertyFile("pwd");
		LoginPage lp = new  LoginPage(driver);
		System.out.println(un + "  " + pwd);
		lp.loginToAPp(un, pwd);
		
	}
	
	@AfterMethod(groups = {"regression","smoke"})
	public void logout()
	{
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.moveToElement(driver, hm.getAdminicon());
		hm.getSignout().click();
		
	}
	
	@AfterClass(groups = {"regression","smoke"})
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
}
