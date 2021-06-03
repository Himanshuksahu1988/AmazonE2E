package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class utility {
	public Properties pros;
	public WebDriver driver;
	
	public ExtentSparkReporter  reporter;

	public WebDriver intialization() throws IOException {
		pros = new Properties();
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "\\src\\main\\java\\Resources\\file.properties");
		pros.load(fis);
		

		String browsername = pros.getProperty("browser");

		// Selecting the Browser

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\java\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\src\\main\\java\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.IE.driver", path + "\\src\\main\\javaResources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		return driver;
	}
	
	
	
		public static String getScreenshot(WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source	=ts.getScreenshotAs(OutputType.FILE);
			String path="B:\\Java\\JavaProject\\AmazonE2E\\src\\main\\java\\Screenshot" +System.currentTimeMillis()+ ".png";
			
			
			File destination=new File(path);
		
			FileUtils.copyFile(source, destination);
			
			return path;
		}
		
		public static ExtentReports getExtentreport()
		{
			ExtentSparkReporter  reporter=new ExtentSparkReporter("./Reports/index.html");
			
			reporter.config().setDocumentTitle("Automation Report");
			reporter.config().setReportName("Himanshu");
			
			
			ExtentReports extent=new ExtentReports();
			extent.attachReporter(reporter);
			
			return extent;
					
			
		}
}

