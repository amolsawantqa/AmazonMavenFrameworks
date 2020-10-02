package amazon.framework.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import amazon.framework.utility.BrowserFactory;
import amazon.framework.utility.ConfigDataProvider;
import amazon.framework.utility.ExcelDataProvider;
import amazon.framework.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;	
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url)
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		excel = new ExcelDataProvider();            
		config = new ConfigDataProvider();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/AmazonFramework_"+Helper.getCurrentDateTime()+".html"));
	  	report = new ExtentReports();
		report.attachReporter(reporter);
		driver = BrowserFactory.startApplication(driver, browser, url);
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());	
		//driver = BrowserFactory.startApplication(driver, "Chrome", "https://www.amazon.co.in");	
		Reporter.log("Setting done Test can be statrted", true);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{		
		BrowserFactory.quitBrowser(driver);
	}
		
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();	
		Reporter.log("Reported Generated", true);
	}	
}
