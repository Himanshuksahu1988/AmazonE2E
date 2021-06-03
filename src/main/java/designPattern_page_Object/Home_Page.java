package designPattern_page_Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

	WebDriver driver;

	By boxclick = By.xpath("//input[@id='twotabsearchtextbox']");
	By srch = By.xpath(
			"//div[@class='s-main-slot s-result-list s-search-results sg-row']/div/div/span/div/div/div[2]/div[2]/div/div/h2/a/span");

	By mouseoverlogin = By.xpath("//span[@class='nav-line-2 nav-long-width']");
	By accnttab = By.cssSelector("a[href*='Flyout_ya'] span");

	public Home_Page(WebDriver driver) {

		this.driver = driver;

	}

//Method for click inside the box and Send serach item.
	public WebElement boxclick() {
		return driver.findElement(boxclick);
	}

//Method for Mobile Serach No. of Mobile
	public List<WebElement> srch() {
		return driver.findElements(srch);
	}

	public WebElement mouseover() {
		return driver.findElement(mouseoverlogin);
	}

	public Login_Page accnttab() {
		driver.findElement(accnttab).click();

		Login_Page lp = new Login_Page();

		return lp;

	}

}
