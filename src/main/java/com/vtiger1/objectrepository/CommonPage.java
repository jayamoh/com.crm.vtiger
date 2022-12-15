package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger1.genericutility.WebDriverUtility;
/**
 * this class is used to store all the common Objects/elements
 * @author jay
 *
 */
public class CommonPage {
	@FindBy(linkText ="Leads") private WebElement leadsTab;
	@FindBy(linkText ="Products") private WebElement productsTab;
	@FindBy(linkText ="Calendar") private WebElement calenderTab;
	@FindBy(linkText ="Contacts") private WebElement contactsTab;
	@FindBy(linkText ="Organizations") private WebElement organizationsTab;
	@FindBy(xpath = "//span[normalize-space(text()=' Administrator')]/../../td[@onmouseover][1]") private WebElement administratorImg;
	@FindBy(linkText ="Sign Out") private WebElement signoutLink;
	private WebDriver driver;
	/**
	 * this constructor is used to initialize the web element during run time
	 * @param driver
	 */
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public   CreatingCalenderPage clickCalendertab() {
		calenderTab.click();
		return new CreatingCalenderPage(driver);

	}
	/**
	 * this method is used to click on Leads tab
	 */
	public void clickLeadsTab() {
		leadsTab.click();
	}
	/**
	 * this method is used to click on organization tab
	 */
	public void clickOrganizationsTab() {
		organizationsTab.click();
	}
	/**
	 * this method is used to move the mouse cursor on required element
	 * @param webdriverUtility
	 */
	public void mouseOverOnAdministratorImg(WebDriverUtility webdriverUtility) {
		webdriverUtility.mouseOverOnElemnet(administratorImg);
	}
	/**
	 * this method is used to click on sign out link
	 */
	public void clickOnSignoutLink() {
		signoutLink.click();
	}
	/**
	 * this method is used to click on Products tab
	 */
	public void clickProductsTab() {
		productsTab.click();
	}
	/**
	 * this method is used to click on contacts tab
	 */
	public void clickContactsTab() {
		contactsTab.click();
	}
}
