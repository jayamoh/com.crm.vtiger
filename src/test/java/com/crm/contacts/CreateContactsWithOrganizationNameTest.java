package com.crm.contacts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amandla.genericutility.BaseClass;
import com.amandla.genericutility.IConstantPath;
import com.amandla.genericutility.SheetName;
/**
 * this class is used to test create contacts with organization name module
 * @author VANNUR
 *
 */
@Listeners(com.amandla.genericutility.ListenerImplementationClass.class)
public class CreateContactsWithOrganizationNameTest extends BaseClass{
	@Parameters("browser")
	@Test(retryAnalyzer =com.amandla.genericutility.RetryImplementationClass.class, groups ="sanity")
	public void createContactsWithOrganizationNameTest(String browser)  {
		System.out.println("createContactsWithOrganizationNameTest   "+browser+"----->"+Thread.currentThread().getId());
		//clicking on contacts tab
		commonPage.clickContactsTab();

		//clicking on create new contacts icon
		createContactsPage.clickCreateContactsIcon();
		//filling all the details in creating new contacts page with organization name
		creatingNewContactPage.selectFirstNameDropDown(webdriverUtility,"Mr.");
		creatingNewContactPage.enterTextInFirstNameTextFiled(ExpectedFirstName);
		creatingNewContactPage.enterTextInLatNameTextFiled(ExpectedLastName);
		creatingNewContactPage.clickOnOrganizationNameLookupIcon();
		creatingNewContactPage.enterTextInOrganizationNameSearchTextBox(webdriverUtility, "\"module=Accounts\"",ExpectedOrganizationName);
		creatingNewContactPage.clickOnsearchNowButton(driver, ExpectedOrganizationName);
		webdriverUtility.handlingWindowsBasedOnUrl("module=Contacts");

		//clicking on save button
		creatingNewContactPage.clickOnSaveButton();
		webdriverUtility.waitCondition(10);
		contactInformationPage.waitForStatusBarInvisible(webdriverUtility);
		//fetching all the details
		String actualFirstName=contactInformationPage.getFirstNameTextFiled();
		String actualLastName=contactInformationPage.getLastNameTextFiled();
		String actualOrganizationName=contactInformationPage.getOrganizationNameTextFiled();
		//verification and validation
		//		Assert.assertEquals(ExpectedLastName, actualLastName);
		//		Assert.assertEquals(ExpectedFirstName, actualFirstName);
		//		Assert.assertEquals(ExpectedOrganizationName, actualOrganizationName);
		Assert.assertTrue(ExpectedLastName.equals(actualLastName) && ExpectedFirstName.contains(actualFirstName) && ExpectedOrganizationName.equals(actualOrganizationName));
		excelUtility.setDataBackToExcel(IConstantPath.EXCEL_PATH, SheetName.CREATELEADS.convertToString(), 1, 7,"pass");

	}
}
