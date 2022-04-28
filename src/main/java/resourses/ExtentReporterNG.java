package resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
public  static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shubham");
		return extent;
	}
}
