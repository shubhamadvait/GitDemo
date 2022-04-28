package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resourses.ExtentReporterNG;
import resourses.base;

public class Listeners extends base implements ITestListener {

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}
	ExtentTest test;
	//ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	ExtentReports extent=ExtentReporterNG.getReportObject();
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
	    
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver =null;
		test.fail(result.getThrowable());
		String testMethodName=result.getMethod().getMethodName();
	   try {
		driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	   {
		
	   }
		try {
		//	extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestResult result) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest("Demo Intial");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Passed");
	}

}
