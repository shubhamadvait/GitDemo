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

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;
	@Test
	public void basePageNavigation() throws IOException {

		// driver.get("https://rahulshettyacademy.com/sign_in/");
		 l = new LandingPage(driver);
		String actualTitle = l.getTitle().getText();
		Assert.assertEquals(actualTitle, "FEATURED 11COURSES");
		log.info("Successfully validated text message");

	}
	@Test
	public void baseHeader() throws IOException {

		// driver.get("https://rahulshettyacademy.com/sign_in/");
		 l = new LandingPage(driver);
		String actualTitle = l.getHeader().getText();
		Assert.assertEquals(actualTitle, "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Successfully validated text message");

	}

	@BeforeTest
	public void intializer() throws IOException {
		driver = intializerDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homePage");

	}

	@AfterTest
	public void tear() {
		driver.close();
	}

}
