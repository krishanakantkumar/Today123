package UtilitiesFile;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.BaseClass;
import junit.framework.TestCase;

public class ExtentReportListener extends BaseClass implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports createTest;
	ExtentTest createLog;

	void setup()
	{
		createReport=new ExtentSparkReporter("MyNewProjectReportF.html");
		createTest=new ExtentReports();
		createTest.attachReporter(createReport);
		
		createTest.setSystemInfo("operating_System","window");
		createTest.setSystemInfo("Browser","Chrome");
		createTest.setSystemInfo("Browser_version","124.0.6367.119");
		createTest.setSystemInfo("Environment","Testing");
		createTest.setSystemInfo("User Name","Krishana singh");
		
		createReport.config().setDocumentTitle("MyprojectInfo");
		createReport.config().setReportName("Module-5-Reports");
		createReport.config().setTheme(Theme.DARK);
		
	}	
public void onStart(ITestContext Result)
{
	setup();
}
public void onFinish(ITestContext Result)
{
	createTest.flush();
}
public void onTestStart(ITestResult Result)
{
	System.out.println("onTestStart");
}
public void onTestSuccess(ITestResult Result)
{
	createLog=createTest.createTest(Result.getName());
	createLog.log(Status.PASS, MarkupHelper.createLabel("pass case",ExtentColor.GREEN ));
}
public void onTestFailure(ITestResult Result)
{ 
	try {
		 screenshot() ;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	createLog=createTest.createTest(Result.getName());
	createLog.log(Status.FAIL, MarkupHelper.createLabel("pass case",ExtentColor.RED));
	String Path="C:\\Users\\abhay\\eclipse-workspace\\MyFRAMEWORKproject\\ScreenShotg\\h3.png";
	createLog.fail("fail screenshot"+createLog.addScreenCaptureFromPath(Path));

}
public void onTestSkipped(ITestResult Result)
{
	createLog=createTest.createTest(Result.getName());
	createLog.log(Status.SKIP, MarkupHelper.createLabel("skip case",ExtentColor.ORANGE ));
	
}


}

	


