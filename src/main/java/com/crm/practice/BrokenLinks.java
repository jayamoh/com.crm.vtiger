package com.crm.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amandla.genericutility.WebDriverUtility;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverUtility webDriverUtility=new WebDriverUtility();
		WebDriver driver = webDriverUtility.launchApplication("chrome", 10, "https://www.facebook.com");
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < listOfLinks.size(); i++) {
			String url=listOfLinks.get(i).getAttribute("href");
			try {
				URL url1=new URL(url);
				URLConnection urlConnection = url1.openConnection();
				HttpURLConnection httpConnection=(HttpURLConnection) urlConnection;
				int statusCode = httpConnection.getResponseCode();
				if (statusCode!=200) {
					System.out.println("broken link=====>"+url+"======>"+httpConnection.getResponseMessage() );
				}
			}
			catch(Exception e){
				System.out.println("there is a pblm with url "+url);
			}
		}
	}
}
