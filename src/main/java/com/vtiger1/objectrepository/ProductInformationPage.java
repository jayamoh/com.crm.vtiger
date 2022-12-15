package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger1.genericutility.WebDriverUtility;
/**
 * this class is used to store all the objects/elements present in the ProductInformationPage
 * @author jay
 *
 */
public class ProductInformationPage {
	@FindBy(xpath ="//div[@id='status']") private WebElement statusBar;
	@FindBy(xpath ="//td[contains(.,'Product Name') and @class='dvtCellLabel']/following-sibling::td/span") private WebElement productNameTextField;
	@FindBy(xpath ="//td[contains(.,'Sales Start') and @class='dvtCellLabel']/following-sibling::td/span[@id='dtlview_Sales Start Date']") private WebElement startDateTextFiled;
	@FindBy(xpath ="//td[contains(.,'Sales End Date') and @class='dvtCellLabel']/following-sibling::td/span") private WebElement endDataeTextField;
	@FindBy(xpath ="//td[text()='Vendor Name']/../td[2]/a") private WebElement vendorNameLink;
	/**
	 * it is used to initialize the WebElements during run time
	 * @param driver
	 */
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * it is used to wait an element to be invisible
	 * @param webdriverUtility
	 */
	public void waitForStatusBarInvisible(WebDriverUtility webdriverUtility) {
		webdriverUtility.waitForElementToBeInvisible(statusBar);
	}
	/**
	 * this method is used to get the product name
	 * @return
	 */
	public String getProductNameTextField() {
		return productNameTextField.getText();
	}
	/**
	 * this method is used to get the Start date text 
	 * @return
	 */
	public String getStartDateTextFiled() {
		return startDateTextFiled.getText();
	}
	/**
	 * this method is used to get the text from the end date text field
	 * @return
	 */
	public String getEndDataTextField() {
		return endDataeTextField.getText();
	}
	/**
	 * this method is used to get the text from the vendor name text field
	 * @return
	 */
	public String getvendorNameLink() {
		return vendorNameLink.getText();
	}

}
