package com.vtiger1.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger1.genericutility.WebDriverUtility;
/**
 * This class is used to store the Objects/elements of CreatingNewContactPage
 * @author jay
 *
 */
public class CreatingNewContactPage {
	@FindBy(xpath ="//td[contains(text(),'First Name')]/../td/select") private WebElement FirstNameDropDown;
	@FindBy(xpath ="//td[contains(text(),'First Name')]/..//input[@name='firstname']") private WebElement FirstNameTextFiled;
	@FindBy(name ="lastname") private WebElement lastNameTextFiled;
	@FindBy(xpath ="//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td/img") private WebElement organizationNameLookupIcon;
	@FindBy(name="search_text") private WebElement organizationNameSearchTextBox;
	@FindBy(name="search") private WebElement searchNowButton;
	@FindBy(xpath="//input[@name='button' and contains(@value,'Save')]") private WebElement saveButton;	
	String partialXpath="//a[text()='%s']";
	/**
	 * it is used to initialize WebElements during run time
	 * @param driver
	 */
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to handle dynamic XPATH
	 * @param partialXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	private  WebElement StringToWebElement(String partialXpath,String replaceData,WebDriver driver) {
		String xpath=String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	/**
	 * this method is used to select first name drop down
	 * @param webdriverUtility
	 * @param value
	 */
	public void selectFirstNameDropDown(WebDriverUtility webdriverUtility,String value) {
		Select s=webdriverUtility.handlingDropDown(FirstNameDropDown);
		s.selectByValue(value);
	}
	/**
	 * this method is used to enter text in the first name text field
	 * @param ExpectedFirstName
	 */
	public void enterTextInFirstNameTextFiled(String ExpectedFirstName) {
		FirstNameTextFiled.sendKeys(ExpectedFirstName);
	}
	/**
	 * this method is used to enter the text in the last name text field
	 * @param ExpectedLastName
	 */
	public void enterTextInLatNameTextFiled(String ExpectedLastName) {
		lastNameTextFiled.sendKeys(ExpectedLastName);
	}
	/**
	 * this method is used to click on organization name lookup icon
	 */
	public void clickOnOrganizationNameLookupIcon() {
		organizationNameLookupIcon.click();
	}
	/**
	 * this method is used to enter the text in the OrganizationNameSearchTextBox
	 * @param webdriverUtility
	 * @param expectedUrl
	 * @param expectedOrganizationName
	 */
	public void enterTextInOrganizationNameSearchTextBox(WebDriverUtility webdriverUtility,String expectedUrl,String expectedOrganizationName) {
		webdriverUtility.handlingWindowsBasedOnUrl(expectedUrl);
		organizationNameSearchTextBox.sendKeys(expectedOrganizationName);
	}
	/**
	 * this method is used to click on search now button
	 * @param driver
	 * @param expectedOrganizationName
	 */
	public void clickOnsearchNowButton(WebDriver driver,String expectedOrganizationName) {
		searchNowButton.click();
		StringToWebElement(partialXpath,expectedOrganizationName,driver).click();
	}
	/**
	 * this method is used to click on save button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
