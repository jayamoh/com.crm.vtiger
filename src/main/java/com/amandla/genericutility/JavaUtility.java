package com.amandla.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class contains java reusable methods
 * @author VANNUR
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
	/**
	 * this method is used to fetch system date and time in dd_MM_YYYY_HH_MM_SSS format
	 * @return
	 */
	public String getDateTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_MM_SSS");
		String d=sdf.format(date);
		System.out.println(d);
		return d;
	}

}
