package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to store all the objects of CreateOrganizationsPage
 * @author jay
 *
 */
public class CreateOrganizationsPage {

	@FindBy(xpath ="//img[@title='Create Organization...']") private WebElement createOrganizationIcon;
	/**
	 * it is used to initialize the webElemets during run time
	 * @param driver
	 */
	public CreateOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to click on CreateOganization icon
	 */
	public void clickCreateOrganizationIcon() {
		createOrganizationIcon.click();
	}

}
