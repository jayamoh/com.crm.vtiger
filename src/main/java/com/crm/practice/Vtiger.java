package com.crm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//program to click check box in organization list page of vtiger aplication by giving organization name as expected
public class Vtiger {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expectedOrgName="";
		driver.findElement(By.xpath("//td[='tabUnSelected']/a[text()='Organizations']")).click();
		List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));

		for (int i = 0,x=0; i <listOrg.size(); i++) {
			if(i==1)
				x=2;
			String actualOrgName=listOrg.get(i).getText();    //i=0  x=1, i=1 x=3, i=2 x=4, i=3 x=5 x=tr
			if (actualOrgName.equals(expectedOrgName)) {
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(x+1)+"]/td/input")).click();
				break;
			}
			x++;
		}

	}

}
