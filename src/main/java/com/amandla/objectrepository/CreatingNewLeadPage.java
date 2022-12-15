package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amandla.genericutility.WebDriverUtility;
/**
 * it is used to store all the objects/elements in CreatingNewLeadPage
 * @author VANNUR
 *
 */
public class CreatingNewLeadPage {
	@FindBy(xpath ="//td[contains(text(),'First Name')]/../td/select") private WebElement FirstNameDropDown;
	@FindBy(xpath ="//td[contains(text(),'First Name')]/..//input[@name='firstname']") private WebElement FirstNameTextFiled;
	@FindBy(name ="lastname") private WebElement lastNameTextFiled;
	@FindBy(name ="company") private WebElement companyTextFiled;
	@FindBy(xpath="//input[@type='radio'][2]") private WebElement groupRadioButton;
	@FindBy(xpath="//input[@name='button' and contains(@value,'Save')]") private WebElement saveButton;
	/**
	 * it is used to initialize the WebElements during run time
	 * @param driver
	 */
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to select value from firstName dropDown
	 * @param webdriverUtility
	 * @param value
	 */
	public void selectFirstNameDropDown(WebDriverUtility webdriverUtility,String value) {
		Select s=webdriverUtility.handlingDropDown(FirstNameDropDown);
		s.selectByValue(value);
	}
	/**
	 * this method is used to enter the text in the first name text field
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
	 * this method is used to enter the Text In CompanyTextFiled
	 * @param ExpectedCompanyName
	 */
	public void enterTextInCompanyTextFiled(String ExpectedCompanyName) {
		companyTextFiled.sendKeys(ExpectedCompanyName);
	}
	/**
	 * this method is used to click on the GroupRadioButton
	 */
	public void clickOnGroupRadioButton() {
		groupRadioButton.click();
	}
	/**
	 * this method is used to click on save button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
