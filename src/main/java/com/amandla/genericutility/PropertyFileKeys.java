package com.amandla.genericutility;
/**
 * this class contains property file keys
 * @author VANNUR
 *
 */
public enum PropertyFileKeys {
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout"),
	RANDOM_NUMBER_LIMIT("randomnumberlimit");

	private String keys;
	/**
	 * it is used to initialize keys
	 * @param keys
	 */
	private PropertyFileKeys(String keys) { //USERNAME
		this.keys=keys;
	}
	/**
	 * it is used to return keys
	 * @return
	 */
	//getter
	public String convertToString() {
		return keys.toString();
	}
}
