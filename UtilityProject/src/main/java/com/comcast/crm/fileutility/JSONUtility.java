package com.comcast.crm.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException
	{
		FileReader fis = new FileReader("./configAppData/config.json");
		JSONParser p = new JSONParser();
		Object o =  p.parse(fis);
		JSONObject obj = (JSONObject) o ;
		
		
		return (String) obj.get(key);		
	}
}
