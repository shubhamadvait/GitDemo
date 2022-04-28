package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By email=By.id("user_email");
	By password=By.cssSelector("input[type='password']");
	By login =By.cssSelector("input[name='commit']");
	By forgetPasssword=By.cssSelector("a[href*='password/new']");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public ForgetPasswordPage getForgetPasssword()
	{
		driver.findElement(forgetPasssword).click();;
		ForgetPasswordPage fp=new ForgetPasswordPage(driver);
		return fp;
	}
}
