package com.vtiger.Genericutility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author saraswata
 *
 */

public class FileUtility {
	     /**
		 * it is used to get all the proprties file data as per requirment
	     * @throws Throwable 
		 * @param key
		 * 
		 */
	public String getPropertyKeyValue(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/credential.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Value=pobj.getProperty(key);
		return Value;
		
		
	}
	
		
	
}

