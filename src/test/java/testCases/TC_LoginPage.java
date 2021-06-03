package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.utility;
import designPattern_page_Object.Home_Page;
import designPattern_page_Object.Login_Page;

public class TC_LoginPage extends utility
{
	WebDriver driver;
	
	
@Test
	public void loginpage() throws IOException
	{
		driver= intialization();
		String path=pros.getProperty("url");
		driver.get(path);
		driver.manage().window().maximize();
		
		Home_Page hp=new Home_Page(driver);
		
		//Mouse over to the Element
		Actions actn=new Actions(driver);
		actn.moveToElement(hp.mouseover()).build().perform();
		
		//Login Page
		Login_Page lp=hp.accnttab();
		
		System.out.println(lp.getLogin().getText());
		
		
	}
	

}
