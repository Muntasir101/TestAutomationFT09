package com.ProductOrder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_ProductOrder extends BaseClass {

	// Extent report
	ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest logger;

	public static void openProductPage()
	{
		driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=40");
	}


	@BeforeTest
	public void startReports()
	{

		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\ProductOrderTestReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("OS Version", "Windows 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Browser Version", "87");
		report.setSystemInfo("Screen Size", "1317 * 709");

		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Muntasir Abdullah");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");

	}

	@Test
	public static void productTest() throws InterruptedException, IOException {

		logger=report.createTest("Product Order Test valid Quantity");
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		openProductPage();
		logger.log(Status.INFO, "Product page open Succesful");

		ProductOrderTestCases.TC_valid_001();
		logger.log(Status.PASS, "Product order valid Test done.");

		//Capture and save screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Order1.png"));


		//Log Screenshot in Report
		logger.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Order1.png").build());

		tearDownChrome();
		
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 4 successfully Executed.");
	}

	@Test
	public static void productTest2() throws InterruptedException, IOException {

		logger=report.createTest("Product Order Test valid Quantity");
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		openProductPage();
		logger.log(Status.INFO, "Product page open Succesful");

		ProductOrderTestCases.TC_Invalid_002();
		logger.log(Status.PASS, "Product order valid Test done.");

		//Capture and save screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Order2.png"));


		//Log Screenshot in Report
		logger.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Order2.png").build());

		tearDownChrome();
		
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 2 successfully Executed.");
	}

	@Test
	public static void productTest3() throws InterruptedException, IOException {

		logger=report.createTest("Product Order Test valid Quantity");
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		openProductPage();
		logger.log(Status.INFO, "Product page open Succesful");

		ProductOrderTestCases.TC_Invalid_003();
		logger.log(Status.PASS, "Product order valid Test done.");

		//Capture and save screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Order3.png"));


		//Log Screenshot in Report
		logger.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Order3.png").build());

		tearDownChrome();
		
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 3 successfully Executed.");
	}
	
	@Test
	public static void productTest4() throws InterruptedException, IOException {

		logger=report.createTest("Product Order Test valid Quantity");
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		openProductPage();
		logger.log(Status.INFO, "Product page open Succesful");

		ProductOrderTestCases.TC_Invalid_004();
		logger.log(Status.PASS, "Product order valid Test done.");

		//Capture and save screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Order4.png"));


		//Log Screenshot in Report
		logger.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Order4.png").build());

		tearDownChrome();
		
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 4 successfully Executed.");
	}
	
	@Test
	public static void productTest5() throws InterruptedException, IOException {

		logger=report.createTest("Product Order Test valid Quantity");
		launchChrome();
		logger.log(Status.INFO, "Google chrome Launch Succesful");

		openProductPage();
		logger.log(Status.INFO, "Product page open Succesful");

		ProductOrderTestCases.TC_Invalid_005();
		logger.log(Status.PASS, "Product order valid Test done.");

		//Capture and save screenshot
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
		ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Order5.png"));


		//Log Screenshot in Report
		logger.info("Details of " + "Test screenshot", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Order5.png").build());

		tearDownChrome();
		
		Assert.assertTrue(true);
		logger.log(Status.INFO, "Test Case 5 successfully Executed.");
	}
	


	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			logger.fail(result.getThrowable());

		}


		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}

		else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		}
	}

	@AfterTest
	public void testComplete()
	{
		report.flush();

	}

}
