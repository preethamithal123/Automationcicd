package rahulshettyacademy.TestComponents;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import rahulshettyacademy.resourses.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;

	ExtentReports extent=ExtentReporterNG .getExtentReportObject();
	
	    @Override
	    public void onTestStart(ITestResult result) {
	        // Code to run when a test starts
	    test=	extent.createTest(result.getMethod().getMethodName());
	    	
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Code to run when a test succeeds
	    	test.log(Status.PASS, "test is passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Code to run when a test fails
	    	test.fail(result.getThrowable());
	   try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	//	WebDriver	driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	
	    	
	    	String filepath=null;
			try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Code to run when a test is skipped
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Code to run when a test fails but is within success percentage
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Code to run before any tests start
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Code to run after all tests have finished
	    	extent.flush();
	    }
	}
	
	
	


