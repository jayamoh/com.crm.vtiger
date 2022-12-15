package com.crm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("birthday_day")).click();
		List<WebElement> options = driver.findElements(By.xpath("//select[@name='birthday_day']/option"));
		for (WebElement option : options) {
			if ("16".contains(option.getText())) {
				Thread.sleep(2000);
				option.click();
			}
		}
		driver.findElement(By.name("birthday_day")).click();
	}

}
