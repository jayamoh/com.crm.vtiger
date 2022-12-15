package com.vtiger1.genericutility;
/**
 * this class is used to store proprty file keys
 * @author jay
 * 
 * 
 */
public enum PropertyFileKeys {
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("TIMEOUT"),
	RANDOM_NUMBER_LIMIT("randomnumberlimit");

	private String keys;
	//setter
	private PropertyFileKeys(String keys) { //USERNAME
		this.keys=keys;
	}
	//getter
	public String convertToString() {
		return keys.toString();
	}
}
