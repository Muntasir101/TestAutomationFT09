package com.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
 * Add screenshot when test case failed
 */

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Demo.HomePage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.login.LoginTest;

public class CustomReport extends BaseClass {

	// Extent report
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest logger;

	WebDriver driver;

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	@Test
	public void login() throws Exception
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\LoginTestReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("OS Version", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Browser Version", "87");
		report.setSystemInfo("Screen Size", "1317 * 709");

		logger=report.createTest("Login Test");

		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		HomePage.openHomepage();
		logger.log(Status.INFO, "Home page open Succesful");

		LoginTest.openLoginURL();
		logger.log(Status.INFO, "Login page open Succesful");

		LoginTest.emailPassInValid();
		logger.log(Status.PASS, "Login by invalid Email and Pasword Test done.");

		LoginTest.emailValidPassInValid();		
		logger.log(Status.PASS, "Login by Email valid and Pasword invalid Test done.");

		LoginTest.emailInValidPassValid();		
		logger.log(Status.PASS, "Login by Email invalid and Pasword valid Test done.");

		LoginTest.emailPassValid();		
		logger.log(Status.PASS, "Login by valid Email and Pasword Test done.");

		
		
		LoginTest.tearDownChrome();
		logger.log(Status.INFO, "Browser Close successful.");

		logger.log(Status.PASS, "Successfully Test case Executed.");

		report.flush();		
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.PASS, "Test Case PASSED is "+result.getName());
			logger.log(Status.PASS, "Test Case PASSED is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
			String screenshotPath = CustomReport.getScreenhot(driver, result.getName());
			//To add it in the extent report 
			//logger.log(Status.FAIL, logger.CustomReport(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		report.flush();
	}
	
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
		report.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
		
    }

}
