package com.crm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//program to click check box in organization list page of V_tiger application by giving organization name as expected and if organization name not 
//available in one page we will move to another page
public class Vtiger1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
		int pageNum = Integer.parseInt(page.split(" ")[1]); //2
		boolean notPresenceOfObject=false;
		String expectedOrgName="org7";
		for (int j = 0; j < pageNum; j++) {
			List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
			for (int i = 0,x=0; i <listOrg.size(); i++) {
				if(i==1)
					x=2;
				String actualOrgName=listOrg.get(i).getText();    //i=0  x=1, i=1 x=3, i=2 x=4, i=3 x=5 x=tr
				if (actualOrgName.equals(expectedOrgName)) {
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(x+1)+"]/td/input")).click();
					notPresenceOfObject=true;
					break;    
				}
				x++;
			}  
			if (notPresenceOfObject) 
				break;
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			WebElement statusBar = driver.findElement(By.xpath("//div[@id='status']"));
			wait.until(ExpectedConditions.invisibilityOf(statusBar));
		}
	}
}
