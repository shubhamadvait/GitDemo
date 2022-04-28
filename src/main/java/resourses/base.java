package resourses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver	driver;
	public Properties prop;
	public WebDriver intializerDriver() throws IOException
	{
		 prop =new Properties();
		 
		// FileInputStream fis=new FileInputStream("C:\\Users\\ACER\\eclipse-workspace\\E2EProject\\src\\main\\java\\resourses\\data.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\data.properties");
		prop.load(fis);
		
		//for maven "mvn test -Dbrowser=chrome"
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			ChromeOptions Options=new  ChromeOptions();
			if(browserName.contains("headless"))
			{
			Options.addArguments("headless");
			}
			 driver = new ChromeDriver(Options);	
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	*/
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
		 	
			  driver =new  FirefoxDriver();	*/
			WebDriverManager.firefoxdriver().setup();
			driver =new  FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver =new  InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();

			driver =new  EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("brave"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver =new  ChromeDriver(opt);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String destinationFile=System.getProperty("user.dir")+"\\report\\"+testCaseName+".png";
	FileUtils.copyFile(src,new File(destinationFile));
	return destinationFile;
	}
}
