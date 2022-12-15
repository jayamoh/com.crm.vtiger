package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//program to print product name and price in the output console
public class ProductNames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='X']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
		List<WebElement> productNames = driver.findElements(By.xpath("//div[contains(text(),'iPhone')]"));
		List<WebElement> prod_Price = driver.findElements(By.xpath("//div[contains(text(),'iPhone')]/../..//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println("productName---------------------ProductPrice");
		for (int i = 0; i <prod_Price.size(); i++) {
			System.out.println(productNames.get(i).getText()+"--------"+prod_Price.get(i).getText());
		}
	}

}
