package rahulshettyacademy.resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	
	
public  static  ExtentReports getExtentReportObject()
{
		
		String path1= System.getProperty("user.dir")+"//reports//html.index";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path1);
		reporter.config().setReportName("Automation");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "preetham A ithal");
		return extent;
	}

}
