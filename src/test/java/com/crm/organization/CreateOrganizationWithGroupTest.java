package com.crm.organization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithGroupTest {

	public static void main(String[] args) throws IOException 
	{

		FileInputStream file=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(file);
		String browser = p.getProperty("browser");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String url=p.getProperty("url");
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		int randomNum=new Random().nextInt(1000);
		String organization_name=workbook.getSheet("Sheet1").getRow(6).getCell(1).getStringCellValue()+randomNum;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random ran=new Random();
		int names = ran.nextInt(100);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization_name+names);
		driver.findElement(By.xpath("//input[@type='radio' and @ value='T']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebDriverWait waite=new WebDriverWait(driver, 10);
		String values = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		String value2 = driver.findElement(By.xpath("//span[@id='dtlview_Assigned To']/a")).getText();

		if(values.equals(organization_name+names) && value2.equals("Marketing Group"))
		{ 
			System.out.println("testcase passed");
			workbook.getSheet("Sheet1").getRow(1).getCell(7).setCellValue("pass");
			FileOutputStream fos=new FileOutputStream("F:\\weekend\\com.crm.amandla\\src\\test\\resources\\TestData.xlsx");
			workbook.write(fos);
		}
		else {
			System.out.println("testcase is failed");
		}
		driver.quit();
	}

}

