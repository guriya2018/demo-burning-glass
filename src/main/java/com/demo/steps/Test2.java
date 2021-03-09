package com.demo.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.demo.helper.Utility;

import junit.framework.Assert;

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
		// String filePath = Utility.getAbsolutePath() +
		// "/src/test/resources/testData/Dummy.docx";
		String filePath = "C:\\Users\\44745\\eclipse-workspace\\demo-burning-glass\\src\\test\\resources\\testData\\Test.docx";
		System.out.println(filePath);
		Utility.uploadFile(
				"C:\\Users\\44745\\eclipse-workspace\\demo-burning-glass\\src\\test\\resources\\testData\\Dummy.docx");
		Thread.sleep(2000);
		String freeRegistration = driver.findElement(By.xpath("//div[contains(text(),'Register with us for Free! ')]"))
				.getText();
		System.out.println(freeRegistration);
		Thread.sleep(2000);

		// Assert.assertEquals("Register with us for Free! ", freeRegistration);
		driver.findElement(By.id("name")).sendKeys("Test");
		driver.findElement(By.id("email")).sendKeys("testuser678@mailinator.com");
		driver.findElement(By.id("mobile")).sendKeys("9871234567");
		driver.findElement(By.xpath("//input[@id='exp-years-droopeFor']")).click();
		driver.findElement(By.xpath("//div[@id='ul_exp-years-droope']/ul/li[4]")).click();
		driver.findElement(By.xpath("//input[@id='exp-month-droopeFor']")).click();
		driver.findElement(By.xpath("//div[@id='ul_exp-month-droope']/ul/li[5]")).click();
		driver.findElement(By.id("password")).sendKeys("Password1!");
		driver.findElement(By.id("submitBtn")).click();

	}

}
