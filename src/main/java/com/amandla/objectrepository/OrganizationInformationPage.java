package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amandla.genericutility.WebDriverUtility;
/**
 * this class is used to store all the objects of Organization Information page
 * @author VANNUR
 *
 */
public class OrganizationInformationPage {
	@FindBy(xpath ="//div[@id='status']") private WebElement statusBar;
	@FindBy(xpath ="//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[1]/span") private WebElement organizationNameTextFiled;
	/**
	 * it is used to initialize the WebElement/objects during the run time
	 * @param driver
	 */
	public OrganizationInformationPage(WebDriver driver) {
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
	 * this method is used to get the organization name
	 * @return
	 */
	public String getOrganizationNameTextFiled() {
		return organizationNameTextFiled.getText();
	}

}
