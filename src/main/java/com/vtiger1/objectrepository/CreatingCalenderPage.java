package com.vtiger1.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingCalenderPage {
@FindBy(xpath="//a[.='All Events & Todos']/preceding::img[@title='Open Calendar...']")
private WebElement calenderTab;

public  CreatingCalenderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void  createCalenderIcone() {
	
	calenderTab.click();
	
}
}
