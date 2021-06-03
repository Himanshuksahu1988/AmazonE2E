package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Resources.utility;
import designPattern_page_Object.Home_Page;

public class TC_HomePage extends utility {

	WebDriver driver;
	Home_Page hp;
	public ExtentReports extent = utility.getExtentreport();
	public ExtentTest logger;
	

	@BeforeTest
	public void initdriver() throws IOException {
		driver = intialization();

		String urlpath = pros.getProperty("url");
		driver.get(urlpath);
		driver.manage().window().maximize();

	}

	// Send the Item and Press Enter
	@Test(priority = 1)
	public void itemsrch() throws IOException {
		hp = new Home_Page(driver);
		hp.boxclick().sendKeys("Redmi", Keys.ENTER);

		System.out.println(driver.getTitle());
//		String path = utility.getScreenshot(driver);
//
//		extent = utility.getExtentreport();
//
//		logger = extent.createTest("Login");
//
//		logger.log(Status.INFO, "Scessfully Got Info");
//		logger.pass("Test IS passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

	}

	// Take the Mibile List
	@Test(priority = 2)
	public void mobilelst() throws IOException {
		for (int i = 0; i <= hp.srch().size() - 1; i++) {
			System.out.println(hp.srch().get(i).getText());
			System.out.println("********************************");
			
//			String path = utility.getScreenshot(driver);
//
//			logger = extent.createTest("Mobilelist");
//
//			logger.log(Status.INFO, "Scessfully Got Info");
//			logger.pass("Test IS passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		}

	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		extent.flush();
	}

	@AfterTest
	public void closebrows() {
		driver.quit();
	}

}
