package com.demo.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.helper.Utility;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition {

	private static final String CHROMEDRIVER_EXE_PATH = "src/main/resources/drivers/chromedriver.exe";
	private String chromeDriverPath = Utility.getAbsolutePath() + File.separator + CHROMEDRIVER_EXE_PATH;
	private WebDriver driver;
	public static String scenarioname;

	@Before
	public void Setup(Scenario scenario) {
		scenarioname = scenario.getName();
		System.out.println("print sceanrio Name" + scenario.getName());
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		// maximize the window size
		driver.manage().window().maximize();
		// deleteX all the cookies
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Given("Navigate to the page {string}")
	public void navigate_to_the_page(String string) {
		driver.get(string);
	}

	@Given("fetch the current values of NSE & BSE from the page")
	public void fetch_the_current_values_of_NSE_BSE_from_the_page() throws InterruptedException {

		driver.switchTo().frame(0); // frame using index

		System.out.println("Enter to the iframe");
		Thread.sleep(1000);
		String bse = driver.findElement(By.id("bseindex")).getText();
		System.out.println("BSE : " + bse);
		Thread.sleep(1000);
		String nse = driver.findElement(By.id("nseindex")).getText();
		System.out.println("NSE : " + nse);
		Thread.sleep(1000);
		// pass driver control to parent window
		driver.switchTo().defaultContent();

	}

	@Given("upload the candidate cv")
	public void upload_the_candidate_cv() throws InterruptedException {
		WebElement uploadFile = driver.findElement(By.xpath("//label[@id='wdgt-file-upload']"));
		Thread.sleep(2000);
		uploadFile.click();
		Thread.sleep(2000);
		String filePath = Utility.getAbsolutePath() + "\\src\\test\\resources\\testData\\Test.docx";
		System.out.println(filePath);
		Utility.uploadFile(filePath);
		Thread.sleep(2000);
		String freeRegistration = driver.findElement(By.xpath("//div[contains(text(),'Register with us for Free! ')]"))
				.getText();
		Thread.sleep(2000);
		Assert.assertTrue("CV uploaded successfully !!, We are at Registration page",
				freeRegistration.contains("Register with us for Free!"));
	}

	@Then("User will filled the details as {string},  email, {string}")
	public void user_will_filled_the_details_as_email(String name, String mobile) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(Utility.generateRandomEmailId());
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@id='exp-years-droopeFor']")).click();
		driver.findElement(By.xpath("//div[@id='ul_exp-years-droope']/ul/li[4]")).click();
		driver.findElement(By.xpath("//input[@id='exp-month-droopeFor']")).click();
		driver.findElement(By.xpath("//div[@id='ul_exp-month-droope']/ul/li[5]")).click();
		driver.findElement(By.id("password")).sendKeys("Password1!");
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(2000);
		Assert.assertTrue("Registration successful!", driver.getTitle().contains("Profile | Mynaukri"));
	}

	@Given("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}
