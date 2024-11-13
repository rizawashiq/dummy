package com.comcast.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListnerImp implements IRetryAnalyzer {

	int count = 0 ;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count <=5)
		{
			count++ ;
			return true ;
		}
		return false;
	}

}
