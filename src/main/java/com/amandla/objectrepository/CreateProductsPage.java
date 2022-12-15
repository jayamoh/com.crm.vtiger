package com.amandla.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to store all the objects/elements of CreateProductsPage
 * @author VANNUR
 *
 */
public class CreateProductsPage {
	@FindBy(xpath ="//img[@title='Create Product...']") private WebElement createProductsIcon;
	/**
	 * it is used to initialize the WebElement during run time
	 * @param driver
	 */
	public CreateProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to click on the products icon
	 */
	public void clickCreateProductsIcon() {
		createProductsIcon.click();
	}
}
