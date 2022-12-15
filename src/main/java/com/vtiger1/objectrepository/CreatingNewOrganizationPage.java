package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to store all the Objects/elements of CreatingNewOrganizationPage
 * @author jay
 *
 */
public class CreatingNewOrganizationPage {
	@FindBy(xpath ="//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td/input[@name='accountname']") private WebElement organizationNameTextField;
	@FindBy(xpath ="//input[@name='button' and contains(@value,'Save')]") private WebElement saveButton;
/**
 * it is used to initialize the WebElements during the run time
 * @param driver
 */
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to enter the text into the Organization name text field..
	 * @param ExpectedOrgName
	 */
	public void enterTextInOrganizationNameTextFiled(String ExpectedOrgName) {
		organizationNameTextField.sendKeys(ExpectedOrgName);
	}
	/**
	 * this method is used to click on the save button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
