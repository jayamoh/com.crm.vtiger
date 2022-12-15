package com.crm.testClassesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceParallelExecution {
	@Parameters("browser")
	/*
	@Test
	public void test(String browser) {
		System.out.println("practiceParallel==>"+Thread.currentThread().getId());
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}
	/*
	 * 
	 */
	@Test
	public void test2() throws InterruptedException {
		System.out.println("practiceParallelExecutin==>"+Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void test3() throws InterruptedException {
		System.out.println("practiceParallelExecutin==>"+Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void test4() throws InterruptedException {
		System.out.println("practiceParallelExecutin==>"+Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.quit();
}
	}
