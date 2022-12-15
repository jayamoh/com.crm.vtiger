package com.crm.vendors;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateVendors {



	public static void main(String[] args)
	{
		int rdmnum=new Random().nextInt(100);
		String expectedvendorName="Test"+rdmnum;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/");		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Vendors")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(expectedvendorName);
		WebElement GLAccount1=driver.findElement(By.name("glacct"));
		Select GLAccount2=new Select(GLAccount1);
		GLAccount2.selectByValue("302-Rental-Income");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		String actualvendorName=driver.findElement(By.id("dtlview_Vendor Name")).getText();
		String expectedGLSelection=driver.findElement(By.xpath("//select[@name='glacct']/option[contains(text(),'302-Rental-Income')]")).getText();
		String actualGLSelection=driver.findElement(By.xpath("//span[@id='dtlview_GL Account']/font")).getText();
		if(actualvendorName.equals(expectedvendorName) && actualGLSelection.contains(expectedGLSelection))
		{
			System.out.println("TestCase Passed and Vendor had created successfully");
		}
		else
		{
			System.out.println("TestCase Failed and Vendor had not created");
		}
		driver.quit();
	}
}


