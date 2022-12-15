package com.crm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggEx {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java");
		List<WebElement> autoSugg = driver.findElements(By.xpath("//span[contains(text(),'java')]"));
		Thread.sleep(2000);
		System.out.println(autoSugg.get(0).getText());
		for (int i = 0; i < autoSugg.size(); i++) {
			System.out.println(autoSugg.get(i).getText());
		}

	}

}
