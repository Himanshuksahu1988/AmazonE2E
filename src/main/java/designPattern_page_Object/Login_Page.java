package designPattern_page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page 
{
WebDriver driver;
By lgnpage=By.xpath("//div[@class='a-container']/div/div[2]/div[2]/a/div/div/div/div[2]/h2");
	
	
public Login_Page() 
{
	this.driver=driver;
}
	

public WebElement getLogin()
{
	return driver.findElement(lgnpage);
}
	

}
