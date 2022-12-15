package com.crm.practice;

//program to print price of all the different products from amazon website
public class Demo {
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.amazon.in/s?k=mobile&crid=3UC9TPFCWQM48&sprefix=mobile%2Caps%2C844&ref=nb_sb_noss_1");
//		List<String> productList=new ArrayList<String>();
//		productList.add("Samsung Galaxy M53 5G (Mystique Green, 6GB, 128GB Storage) | 108MP | sAmoled+ 120Hz | 12GB RAM with RAM Plus | Travel Adapter to be Purchased Separately");
//		productList.add("Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)");
//		productList.add("Redmi 9A Sport (Coral Green, 2GB RAM, 32GB Storage) | 2GHz Octa-core Helio G25 Processor | 5000 mAh Battery");
//		productList.add("SPP Green Mobile Y16 Drizzling Gold, 4GB RAM, 64GB Storage");
//
//		for (String prod_Name : productList) {
//			String price=driver.findElement(By.xpath("//span[text()='"+prod_Name+"']/../../../\r\n" + 
//					"following-sibling::div[@class='sg-row']//span[@class='a-price-whole']")).getText();
//			System.out.println(price);
//		}
		double a = Math.random();
		double b = a*10;
		System.out.println(b);
		System.out.println(Math.floor(b));
		System.out.println((int)Math.floor(b));
	}
}
