package com.Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;

	public static void launchFirefox()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();  // WebDriver changed to driver 
	}

	@BeforeTest
	public static void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void tearDownFirefox()
	{
		if(driver!=null)
		{
			driver.close();
		}
		else {
			System.out.println("No driver found.");
		}
	}
	
	@AfterTest
	public static void tearDownChrome()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
		else {
			System.out.println("No driver found.");
		}
	}
	
	public static void windowSizeScreenshot() throws IOException
	{
		//Take screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Save
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\BugScreenshot.png"),true);	
	}
	
//	public static void CaptureTestScreenshot() throws IOException
//	{
//		//Take screenshot
//		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		//Save
//		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\MyScreenshot.png"),true);	
//	}
	


}
