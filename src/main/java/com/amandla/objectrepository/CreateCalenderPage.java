package com.amandla.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class is used to store WebElements of create calendar page
 * @author VANNUR
 *
 */
public class CreateCalenderPage {
	@FindBy(xpath ="//a[text()='All Events & Todos']/preceding::img[@alt='Open Calendar...']") private WebElement calenderIcon;
	@FindBy(xpath ="//td[@class='calHdr']//b") private WebElement curentYearMonth;
	@FindBy(xpath ="//img[@src='themes/images/small_right.gif']") private WebElement nextButton;
	String partialXpathForReqDate= "//a[text()='%s']";
	String month_Year="//td[@class='calHdr']//b";
	private WebDriver driver;
	/**
	 * it is used to initialize WebElements during run time and also it will initialize the WebDriver type globally
	 * @param driver
	 */
	public CreateCalenderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to convert string to WebElement
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
	 * this method is used to click on calendar icon
	 * @return
	 */
	public CreateCalenderPage clickOnCalenderIcon() {
		calenderIcon.click();
		return this;
	}
	/**
	 * this method is used convert string to By type
	 * @param s
	 * @return
	 */
	public By stringToBy(String s) {
		return By.xpath(s);
	}
	/**
	 * this method is used to handle calendar PopUP
	 */
	public void handlingCalender() {
		String curentYear_Month =curentYearMonth.getText();
		String reqMonth="October";
		String reqYear="2024";
		String reqDay="14";
		String currentMonth=curentYear_Month.split(" ")[0];
		String currentYear=curentYear_Month.split(" ")[1];
		WebDriverWait wait=new WebDriverWait(driver,10);
		while (!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {

			nextButton.click();
			wait.until(ExpectedConditions.invisibilityOfElementWithText(stringToBy(month_Year),curentYear_Month));
			curentYear_Month = curentYearMonth.getText();
			currentMonth=curentYear_Month.split(" ")[0];
			currentYear=curentYear_Month.split(" ")[1];
		}
		StringToWebElement(partialXpathForReqDate, reqDay, driver).click();

	}
}
