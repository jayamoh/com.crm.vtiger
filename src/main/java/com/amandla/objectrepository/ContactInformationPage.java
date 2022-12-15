package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amandla.genericutility.WebDriverUtility;
/**
 * this class is used to store all the objects/elements of ContactInformationPage
 * @author VANNUR
 *
 */
public class ContactInformationPage {
	@FindBy(xpath ="//div[@id='status']") private WebElement statusBar;
	@FindBy(xpath ="//td[contains(text(),'First Name')]/../td[2]/span") private WebElement firstNameTextFiled;
	@FindBy(xpath ="//td[contains(text(),'Last Name')]/../td[2]/span") private WebElement lastNameTextFiled;
	@FindBy(xpath ="//td[text()='Organization Name']/../td[2]/a") private WebElement OrganizationNameTextFiled;
	/**
	 * it is used to initialize all the WebElements during run time
	 * @param driver
	 */
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to wait for an element to be visible
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
	 * this method is used to get the text of Organization name text field
	 * @return
	 */
	public String getOrganizationNameTextFiled() {
		return OrganizationNameTextFiled.getText();
	}
}
