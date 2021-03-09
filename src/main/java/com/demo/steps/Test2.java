package com.demo.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.helper.Utility;

public class Test2 {

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
		// Default timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// navigate to the URL
		driver.get("https://www.naukri.com/");
		WebElement uploadFile = driver.findElement(By.xpath("//label[@id='wdgt-file-upload']"));
		Thread.sleep(2000);
		uploadFile.click();
		Thread.sleep(2000);
		//String filePath = Utility.getAbsolutePath() + "/src/test/resources/testData/Dummy.docx";
		String filePath= "C:\\Users\\44745\\eclipse-workspace\\demo-burning-glass\\src\\test\\resources\\testData\\Test.docx";
		System.out.println(filePath);
		Utility.uploadFile("C:\\Users\\44745\\eclipse-workspace\\demo-burning-glass\\src\\test\\resources\\testData\\Dummy.docx");
		Thread.sleep(2000);
		
	
//		driver.quit();
		
	}

}
