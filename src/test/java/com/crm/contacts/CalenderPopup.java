package com.crm.contacts;

import org.openqa.selenium.WebDriver;

import com.amandla.genericutility.WebDriverUtility;
import com.amandla.objectrepository.LoginPage;

/**
 * this class is used to handle calendar pop up
 * @author VANNUR
 *
 */
public class CalenderPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		WebDriver driver = webDriverUtility.launchApplication("chrome", 10, "http://rmgtestingserver:8888/");
		new LoginPage(driver).loginAction("admin", "admin").clickCalenderTab().clickOnCalenderIcon().handlingCalender();

	}

}
