package com.amandla.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.amandla.objectrepository.CommonPage;
import com.amandla.objectrepository.ContactInformationPage;
import com.amandla.objectrepository.CreateContactsPage;
import com.amandla.objectrepository.CreateProductsPage;
import com.amandla.objectrepository.CreatingNewContactPage;
import com.amandla.objectrepository.CreatingNewProductPage;
import com.amandla.objectrepository.LoginPage;
import com.amandla.objectrepository.ProductInformationPage;
/**   
 * this class contains all the configurations methods of TestNg
 * @author VANNUR
 * workspace2
 *
 */
public class BaseClass {
	protected  ExcelUtility excelUtility;
	protected  WebDriverUtility webdriverUtility;
	protected  String ExpectedFirstName;
	protected  String ExpectedLastName;
	protected  String ExpectedOrganizationName;
	protected  WebDriver driver;
	protected  LoginPage loginPage;
	protected  CommonPage commonPage;
	protected  int randomNum;
	protected JavaUtility javautility;
	protected CreateProductsPage createProductsPage;
	protected CreatingNewProductPage creatingNewProductPage;
	protected ProductInformationPage productInformationPage;
	protected CreatingNewContactPage creatingNewContactPage;
	protected ContactInformationPage contactInformationPage;
	protected CreateContactsPage createContactsPage;
	protected  FeatureFileUtility property;

	/**
	 * this method is used to open the property file,excel file
	 * login to application
	 * object of all generic utility
	 * read data from excel and property file
	 * creating objects of object repository classes 
	 */
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void classSetup(String browser) {
		//creating object of genericUtility classes
		property=new FeatureFileUtility();
		excelUtility=new ExcelUtility();
		webdriverUtility=new WebDriverUtility();
		javautility=new JavaUtility();
		//reading data from property file

		String url=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.convertToString());
		//reading data from excel file
		ExpectedFirstName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 1);
		ExpectedLastName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 2);
		ExpectedOrganizationName=excelUtility.getDataFromExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 4, 3);
		randomNum=javautility.getRandomNumber(1000);
		//launching browser and Application
		ThreadSafe.setWebDriverUtility(webdriverUtility);
		driver=webdriverUtility.launchApplication(browser, 10, url);
		//creating object of objectRepository classes
		loginPage=new LoginPage(driver);
		commonPage=new CommonPage(driver);
		createProductsPage=new CreateProductsPage(driver);
		creatingNewProductPage=new CreatingNewProductPage(driver);
		productInformationPage=new ProductInformationPage(driver);
		createContactsPage=new CreateContactsPage(driver);
		creatingNewContactPage=new CreatingNewContactPage(driver);
		contactInformationPage=new ContactInformationPage(driver);
	}

	/**
	 * this method is used to launch an application 
	 */
	@BeforeMethod(alwaysRun=true)
	public void methodSetup() {
		String username = property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.convertToString());
		String password=property.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.convertToString());
		loginPage.loginAction(username, password);	
	}
	/**
	 * this method is used to sign out an application 
	 */
	@AfterMethod(alwaysRun=true)
	public void methodTearDown() {
		webdriverUtility.initializeActions();
		commonPage.mouseOverOnAdministratorImg(webdriverUtility);
		commonPage.clickOnSignoutLink();	

	}
	/**
	 * this method is used to close excel file
	 * property file
	 * and to close all the windows  
	 */
	@AfterClass(alwaysRun=true)
	public void classTearDown() {
		//close excel
		excelUtility.closeExcel();
		//close property file
		property.closePropertyFile();
		webdriverUtility.quitBrowser();
	}
}
