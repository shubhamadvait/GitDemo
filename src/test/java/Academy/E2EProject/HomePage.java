package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resourses.base;

public class HomePage extends base {
public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
@BeforeTest
	public void intializer() throws IOException
	{
		driver=intializerDriver();
		log.info("Driver is intialized");
	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
	
		driver.get(prop.getProperty("url2"));
		
		//LandingPage l=new LandingPage(driver);
		//l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		lp.getLogin().click();
		log.info(text);
	}
	@AfterTest
	public void tear()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new  Object[2][3];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Non Restricted User";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="556884";
		data[1][2]="Restricted User";
		
		return data;
		
	}
	
	
}
