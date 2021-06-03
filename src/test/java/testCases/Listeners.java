package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Resources.utility;

public class Listeners extends utility implements ITestListener {

	ExtentReports extent = utility.getExtentreport();
	ExtentTest logger;
	WebDriver driver = null;


	@Override
	public void onTestStart(ITestResult result) {
		try {
			 driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		
		try {

			String path = utility.getScreenshot(driver);
			logger.log(Status.PASS, " Test case is Passed " + result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());

		}

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL,"Error : "+result.getThrowable());
		try {
			String path = utility.getScreenshot(driver);
			logger.log(Status.FAIL,"Test case is Failed " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} catch (Exception e) 
		{
			
			System.out.println("Error Message " +e.getMessage());
		}
		

	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		extent.createTest(result.getName());
		
		try {
			String path=utility.getScreenshot(driver);
			logger.log(Status.SKIP, "The Test case is skiped ",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) 
		{
			System.out.println("Error Message :-" +e.getMessage());
		}

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
