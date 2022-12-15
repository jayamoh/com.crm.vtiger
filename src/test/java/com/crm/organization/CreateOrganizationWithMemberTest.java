package com.crm.organization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithMemberTest {

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
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> handle = driver.getWindowHandles();
		String popup=null;
		String handle2 = driver.getWindowHandle();
		for(String window1:handle)
		{
			driver.switchTo().window(window1);
			popup = driver.getCurrentUrl();

			if("Popup&popuptype".contains(popup))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//tr[@bgcolor='white']/td/a")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		// driver.switchTo().window(handle2);
		if(!(popup.equals(handle2)))
		{
			driver.switchTo().window(handle2);
			System.out.println(driver.getTitle());
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String values = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(values.equals(organization_name+names))
		{
			System.out.println("testcase is passed");
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
