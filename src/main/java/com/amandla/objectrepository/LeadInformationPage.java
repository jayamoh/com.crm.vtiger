package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amandla.genericutility.WebDriverUtility;
/**
 * this class is used to store the all the Objects/elements of LeadInformation page
 * @author VANNUR
 *
 */
public class LeadInformationPage {
	@FindBy(xpath ="//div[@id='status']") private WebElement statusBar;
	@FindBy(xpath ="//td[contains(text(),'First Name')]/../td[2]") private WebElement firstNameTextFiled;
	@FindBy(xpath ="//td[contains(text(),'Last Name')]/../td[2]") private WebElement lastNameTextFiled;
	@FindBy(xpath ="//td[contains(text(),'Company')]/../td[2]") private WebElement companyTextFiled;
	/**
	 * it is used to initialize the WebElement/objects during the run time
	 * @param driver
	 */
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to wait for an element to be invisible
	 * @param webdriverUtility
	 */
	public void waitForStatusBarInvisible(WebDriverUtility webdriverUtility) {
		webdriverUtility.waitForElementToBeInvisible(statusBar);
	}
	/**
	 * this method is used to get the text of first name text field
	 * @return
	 */
	public String getFirstNameTextFiled() {
		return firstNameTextFiled.getText();
	}
	/**
	 * this method is used to get the text of last name text field 
	 * @return
	 */
	public String getLastNameTextFiled() {
		return lastNameTextFiled.getText();
	}
	/**
	 * this method is used to get the text from the Company name text field
	 * @return
	 */
	public String getCompanyTextFiled() {
		return companyTextFiled.getText();
	}
}
