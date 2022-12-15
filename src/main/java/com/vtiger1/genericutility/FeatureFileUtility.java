package com.vtiger1.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this class contains reusable methods of property file
 * @author jay
 * 
 *
 */

public class FeatureFileUtility {
	private FileInputStream fis;
	/**
	 * this method is used to fetch the data from property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String propertyFilePath, String key) {

		try {
			fis=new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=property.getProperty(key).trim();
		return value;
	}
	/**
	 * this method is used to close the input stream
	 */
	public void closePropertyFile() {
		try {   
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
