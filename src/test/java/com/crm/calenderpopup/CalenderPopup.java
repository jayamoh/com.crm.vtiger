package com.crm.calenderpopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.Duration;
import com.vtiger1.genericutility.WebDriverUtility;
import com.vtiger1.objectrepository.LoginPage;

public class CalenderPopup {

	public static void main(String[] args) {
		String reqMonth="march";
		String reqYear="2024";
		String reqDays="20";
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	WebDriver driver=webDriverUtility.launchApplication("chrome", 10, "http://rmgtestingserver:8888/");
	new LoginPage(driver).loginAction("admin", "admin").clickCalendertab().createCalenderIcone();
    String currentMonthYear = driver.findElement(By.xpath("//td[@class='calHdr']//b")).getText();
    String currentmonth = currentMonthYear.split(" ")[0];
    String currentyear = currentMonthYear.split(" ")[1];
   // WebDriverWait wait=new WebDriverWait(driver, Duration.)
}

}
