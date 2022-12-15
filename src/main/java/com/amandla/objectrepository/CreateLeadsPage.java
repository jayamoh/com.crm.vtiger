package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to store all the objects/elements of createLeadspage
 * @author VANNUR
 *
 */
public class CreateLeadsPage {
	@FindBy(xpath ="//img[@title='Create Lead...']") private WebElement createLeadIcon;
	/**
	 * it is used to initialize the webElemets during run time
	 * @param driver
	 */
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to click on CreateLeadIcon
	 */
	public void clickCreateLeadIcon() {
		createLeadIcon.click();
	}
}
