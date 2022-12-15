package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * it used to store all the objects/elements of CreateContactsPage
 * @author jay
 *
 */
public class CreateContactsPage {
	@FindBy(xpath ="//img[@title='Create Contact...']") private WebElement createContactsIcon;
	/**
	 * it used to initialize the webElement during the runtime
	 * @param driver
	 */
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to click on create contacts icon
	 */
	public void clickCreateContactsIcon() {
		createContactsIcon.click();
	}
	

}
