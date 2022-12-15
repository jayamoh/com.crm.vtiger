package com.crm.practice;

public class ab {

	//recursive function to reverse a string      
	public static String reverseString(String str)  
	{  
		if(str.isEmpty())  
		{   
			return str;  
		}   
		else   
		{  
			return reverseString(str.substring(1))+str.charAt(0);  
		}  
	}  
	public static void main(String[] args)   
	{  
		String resultantSting1 = reverseString("1245 ");  
		System.out.println(resultantSting1);  
	}  
}  




