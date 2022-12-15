package com.amandla.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amandla.genericutility.WebDriverUtility;
/**
 * this class is used to store all the objects/elements present in the CreatingNewProductPage
 * @author VANNUR
 *
 */
public class CreatingNewProductPage {
	@FindBy(name ="productname") private WebElement productNameTextField;
	@FindBy(name ="discontinued") private WebElement productActiveCheckBox;
	@FindBy(id ="jscal_field_sales_start_date") private WebElement salesStartDateTextField;
	@FindBy(name ="productcategory") private WebElement productCategoryDropdown;
	@FindBy(id="jscal_field_sales_end_date") private WebElement salesEndDateTextField;
	@FindBy(xpath="//img[@title='Select']") private WebElement vendorNameLookupIcon;
	@FindBy(name="search_text") private WebElement vendorNameSearchTextBox;
	@FindBy(name="search") private WebElement searchNowButton;
	@FindBy(xpath="//input[@name='button' and contains(@value,'Save')]") private WebElement saveButton;	
	String partialXpath="//a[text()='%s']";
	/**
	 * this constructor is used to initialize the WebElements/objects during the run time
	 * @param driver
	 */
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to handle the dynamic WebElement
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
	 * this method is used to enter the text in the ProductName Text field
	 * @param expectedProductName
	 */
	public void enterIntoProductNameTextField(String expectedProductName) {
		productNameTextField.sendKeys(expectedProductName);
	}
	/**
	 * this method is used to select/DeSelect the ProductActiveCheckBox
	 */
	public void selectOrDeSelectProductActiveCheckBox() {
		productActiveCheckBox.click();
	}
	public void enterIntoSalesStartDateTextField(String expectedStartDate) {
		salesStartDateTextField.sendKeys(expectedStartDate);
	}
	/**
	 * this method is used to select category from Product category drop down
	 * @param webdriverUtility
	 * @param excepetedProductcat
	 */
	public void selectFromProductCategoryDropdown(WebDriverUtility webdriverUtility,String excepetedProductcat) {
		Select s=webdriverUtility.handlingDropDown(productCategoryDropdown);
		s.selectByValue(excepetedProductcat);
	}
	/**
	 * this method is used to enter text in the Sales end date text field
	 * @param expectedEndDate
	 */
	public void enterIntoSalesEndtDateTextField(String expectedEndDate) {
		salesEndDateTextField.sendKeys(expectedEndDate);
	}
	/**
	 * this method is used to click on vendor name lookup icon
	 */
	public void clickOnVendorNameLookupIcon() {
		vendorNameLookupIcon.click();
	}
	/**
	 * this method is used to enter the text in the Vendor name Search text box
	 * @param webdriverUtility
	 * @param expectedUrl
	 * @param expectedVendorName
	 */
	public void enterTextInVendorNameSearchTextBox(WebDriverUtility webdriverUtility,String expectedUrl,String expectedVendorName) {
		webdriverUtility.handlingWindowsBasedOnUrl(expectedUrl);
		vendorNameSearchTextBox.sendKeys(expectedVendorName);
	}
	/**
	 * this method is used to click on search now button
	 * @param driver
	 * @param expectedVendorName
	 */
	public void clickOnsearchNowButton(WebDriver driver,String expectedVendorName) {
		searchNowButton.click();
		StringToWebElement(partialXpath,expectedVendorName,driver).click();
	}
	/**
	 * 
	 * this method is used to click on save button 
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
