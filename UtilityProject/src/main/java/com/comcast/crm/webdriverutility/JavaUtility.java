package com.comcast.crm.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(5000);
	}
	
	public String getDateInYYYYMMDD()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		 return sdf.format(d);
	}
	
	public   String dateInFormat(String format)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		 return sdf.format(d);
	}
	
	public  String dateAfter(String format , int days)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.format(d);
		Calendar c = sdf.getCalendar();
		c.add(Calendar.DAY_OF_MONTH , days);
		return sdf.format(c.getTime());
	}
	
//	public static void main(String[] args) {
//		System.out.println(dateAfter("YYYY-MM-dd", 30));
//	}
	
	
	
	
	
}
