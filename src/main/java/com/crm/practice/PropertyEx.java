package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyEx {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties property=new Properties();
		property.load(fis);
		System.out.println(property.getProperty("username"));
		fis.close();
	}
}
