package com.demo.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\44745\\eclipse-workspace\\demo-burning-glass\\src\\main\\resources\\drivers\\chromedriver.exe");
		// create an object for ChromeDriver class
		WebDriver driver = new ChromeDriver();
		// maximize he window size
		driver.manage().window().maximize();
		// delate all the cookies
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// navigate to the URL
		driver.get("https://www.rediff.com/");
		// pass a driver control to frame-(class frame/id)
		// driver.switchTo().frame("moneyiframe");
		driver.switchTo().frame(0); // frame using index
		Thread.sleep(2000);
		System.out.println("Enter to the iframe");
		
		String bse = driver.findElement(By.id("bseindex")).getText();
		System.out.println("BSE : " + bse);
		String nse = driver.findElement(By.id("nseindex")).getText();
		System.out.println("NSE : " + nse);

		// pass driver control to parent window
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.quit();
	}
}
