package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to create object repository of the LoginPage and LoginPage Actions
 * @author jay
 *
 */
public class LoginPage {
	@FindBy(name="user_name") private WebElement usernameTextField;
	@FindBy(name="user_password") private WebElement passwordTextField;
	@FindBy(id="submitButton") private WebElement loginButton;
	private WebDriver driver;
	/**
	 * this constructor is used to initialize the web elements during run time
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to perform login actions
	 * @param username
	 * @param password
	 * @return 
	 */
	public CommonPage loginAction(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		return new CommonPage(driver);
	}
	//business library
	/**
	 * this method is used to enter the user name in user name text field
	 * @param username
	 */
	public void enterUserName(String username) {
		usernameTextField.sendKeys(username);
	}
	/**
	 * this method is used to enter the password in the password text field
	 * @param password
	 */
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	/**
	 * this method is used to click on login button
	 */
	public void clickLoginButton() {
		loginButton.click();
	}
}

