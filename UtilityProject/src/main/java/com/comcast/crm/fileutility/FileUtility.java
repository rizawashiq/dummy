package com.comcast.crm.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./configAppData/config.properties");
		Properties p = new Properties();
		p.load(fis);
		
		return p.getProperty(key);		
	}
	
	
	
	
	
	
	
}
