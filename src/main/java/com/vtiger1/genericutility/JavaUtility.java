package com.vtiger1.genericutility;

import java.util.Random;

/**
 * this class contains java reusable methods
 * @author jay
 *
 */
public class JavaUtility {
	/**
	 * this method is used to convert String to long/int data type
	 * @param s
	 * @param strategy
	 * @return
	 */

	public Object stringToAnyDataType(String s,String strategy)
	{
		Object convertedData=null;
		if (strategy.equals("int")) {
			convertedData=Integer.parseInt(strategy);
		}
		else if (strategy.equals("long")) {
			convertedData=Long.parseLong(strategy);
		}
		return convertedData;
	}
	/**
	 * this method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		int random_Number=new Random().nextInt(limit);
		return random_Number;

	}

}
