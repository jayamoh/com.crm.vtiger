package com.amandla.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains common WebDriver actions
 * @author VANNUR
 *
 */
public class WebDriverUtility {
	WebDriver driver=null;
	WebDriverWait wait;
	Actions act;
	/**
	 * this method is used to
	 * launch the browser
	 * setup the Chrome driver executable path
	 * maximize the browser
	 * set the implicit wait
	 * launch the application 
	 * @param browser 
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver launchApplication(String browser,long timeout,String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	/**
	 * this method is used to initialize explicit wait
	 * @param timeunit
	 */
	public void waitCondition(long timeunit ) {
		wait=new WebDriverWait(driver,timeunit);
	}
	/**
	 * this method is used to wait for an element to be invisible
	 * @param timeunit
	 * @param element
	 */
	public void waitForElementToBeInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * this method is used to wait for an element to be visible
	 * @param timeunit
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element) {	
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to wait until partial title is verified
	 * @param timeunit
	 * @param title
	 */
	public void waitForTitleContains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method is used to wait until complete title is verified
	 * @param timeunit
	 * @param title
	 */
	public void waitForTitle(String title) {
		wait.until(ExpectedConditions.titleIs(title));
	}
	/**
	 * this method is used to wait until partial url is verified
	 * @param timeunit
	 * @param partialUrl
	 */
	public void waitForPartialUrl(String partialUrl) {
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	/**
	 * this method is used to wait until complete url is verified
	 * @param timeunit
	 * @param partialUrl
	 */
	public void waitForUrl(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}
	/**
	 * this method is used to accept an alert popup
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to dismiss an alert
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to return the text present in alert popup
	 * @return
	 */
	public String getTextAlert() {
		String text=driver.switchTo().alert().getText();	
		return text;
	}
	/**
	 * this method is used to initialize actions class
	 */
	public void initializeActions() {
		act=new Actions(driver);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElemnet(WebElement element)
	{
		act.moveToElement(element).perform();
	}

	/**
	 * this method is used to handle drop downs
	 * @param webelement
	 */
	public Select handlingDropDown(WebElement webelement) {
		Select s=new Select(webelement);
		return s;
	}
	/**
	 * this method is used handle multiple windows based on url and it will send text to the WebElement(partial url verification)
	 * @param ExpectedUrl
	 * @param ele
	 * @return
	 */
	public void handlingWindowsBasedOnUrl(String ExpectedUrl,String ExpectedVendorName,By ele) {
		Set<String> wid = driver.getWindowHandles();
		for (String id : wid) {
			driver.switchTo().window(id);
			String actualUrl=driver.getCurrentUrl();
			if (actualUrl.contains(ExpectedUrl)) {
				driver.findElement(ele).sendKeys(ExpectedVendorName);
				break;
			}
		}
	}
	/**
	 * this method is used to switch to an window based on only url and will break the statement after switching
	 * @param ExpectedUrl
	 */
	public void handlingWindowsBasedOnUrl(String ExpectedUrl) {
		Set<String> wid = driver.getWindowHandles();
		for (String id : wid) {
			driver.switchTo().window(id);
			String actualUrl=driver.getCurrentUrl();
			if (actualUrl.contains(ExpectedUrl)) {	
				break;
			}
		}
	}
	/**
	 * this method is used to handle multiple windows based on title(complete title verification)
	 * and clicking on particular webElement after switching to window
	 * @param ExpectedTitle
	 * @param ele
	 */
	public void handlingWindowsBasedOnTitle(String ExpectedTitle,By ele) {
		Set<String> wid = driver.getWindowHandles();
		for (String id : wid) {
			driver.switchTo().window(id);
			String actualTitle=driver.getTitle();
			if (actualTitle.equals(ExpectedTitle)) {
				driver.findElement(ele).click();
				break;
			}
		}
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * this method is used to create custom wait and we will click on element
	 * @param element
	 * @param duration
	 */
	public void customWaitAndClick(WebElement element,int duration) {
		int count = 0;
		while(count<duration) {
			try {
				element.click();
				break;
			}catch(WebDriverException we){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					count++;
				}
			}
		}
	}
	/**
	 * this method is used to take screenshot of WebPage and stored in local system
	 * @param testCaseName
	 * @return
	 */
	public String takesScreenShot(String testCaseName) {
		String fileName = testCaseName+"_"+new JavaUtility().getDateTime();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./errorshots/"+fileName+".png");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
	}
	/**
	 * this method is used to take screenshot of WebPage and return
	 * @param testCaseName
	 * @return
	 */
	public String takesScreenShot() {
		TakesScreenshot ts=(TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64); //base 64 is used for temporary storage
	}
	/**
	 * this method is used to close all the windows 
	 */
	public void quitBrowser(){
		driver.quit();
	}
}




