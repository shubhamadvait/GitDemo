package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By signin=By.xpath("//span[contains(text(),'Login')]");
	private By title=By.xpath("//div/h2[text()='Featured Courses']");
	By navbar=By.cssSelector(".nav.navbar-nav.navbar-right> li> a");
  private	By header=By.cssSelector("div[class*='video-banner'] p");
  By popup=By.xpath("//button[text()='NO ThankS']");
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}


	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	public List<WebElement> getPopupSize()
	{
		return driver.findElements(popup);
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
}
