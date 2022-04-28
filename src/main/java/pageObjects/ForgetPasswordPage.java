package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {

	WebDriver driver;
	
	By email=By.id("user_email");
	By sendMeInstructor=By.cssSelector(".btn.btn-primary.btn-md.login-button");
	
	public  ForgetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getSendMeInstructor()
	{
		return driver.findElement(sendMeInstructor);
	}
}
