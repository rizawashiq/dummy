package com.comcast.crm.dummy1;

import java.io.File;
import java.io.IOException;
//import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;

@Listeners(com.comcast.listenerutility.ListenerUtiImpl.class)
public class Listener_Prac extends BaseClass{
	
	@Test(retryAnalyzer = com.comcast.listenerutility.RetryListnerImp.class)
	public void demo1() throws IOException {
		System.out.println("TestCase -1 ");
		System.out.println("TestCase -2 ");
		Assert.assertEquals("Hello", "Hello");
		System.out.println("TestCase -3 ");
		Assert.assertEquals("Hello", "Hell");
		System.out.println("TestCase -4 ");
		
	}
	
	@Test
	public void demo2() {
		System.out.println("TestCase -3 ");
		System.out.println("TestCase -4 ");
		Assert.assertEquals("Hello", "Hllo");
		System.out.println("TestCase -5 ");
		Assert.assertEquals("Hello", "Hell");
		System.out.println("TestCase -6 ");
		
	}
	
}
