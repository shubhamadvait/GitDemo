package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resourses.base;

public class validateNavigationBar extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void intializer() throws IOException
	{
		driver=intializerDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homePage");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		//driver.get("https://rahulshettyacademy.com/sign_in/");
		LandingPage l=new LandingPage(driver);
	Assert.assertTrue(l.getNavbar().isDisplayed());
	log.info("Navigation bas is displayed");
		
		
	}
	@AfterTest
	public void tear()
	{
		driver.close();
	}
	
	
}
