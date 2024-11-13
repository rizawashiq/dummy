package com.comcast.crm.dummy1;

import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objextrepositoryutility.LoginPage;

/**
 * @author Mohammed Riza Washiq
 * 
 */

public class SearchContactTest extends BaseClass {

	/**
	 * Scenario --> 
	 */
	@Test
	public void searchContactTest() {
		
		/* step-1 : login to app */
		LoginPage lp = new LoginPage(driver);
		lp.loginToAPp(null, null);
	}
}
