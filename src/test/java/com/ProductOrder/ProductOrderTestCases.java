package com.ProductOrder;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Base.BaseClass;

public class ProductOrderTestCases extends BaseClass{
	
	public static void TC_valid_001() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		
		WebElement Qty=driver.findElement(By.id("input-quantity"));
		WebElement AddCart=driver.findElement(By.id("button-cart"));

		Qty.clear();
		Qty.sendKeys("1");
		AddCart.click();

		Thread.sleep(3000);

		//Validation
		String ExpectedMessage="Success: You have added ";
		String ActualMessage=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();

		if(ActualMessage.contains(ExpectedMessage))
		{
			System.out.println("TC_valid_001 Test Passed");
		}

		else
		{
			System.out.println("TC_valid_001 Test Failed.");
		}
	}

	
	public static void TC_Invalid_002() throws InterruptedException, IOException
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		WebElement Qty=driver.findElement(By.id("input-quantity"));
		WebElement AddCart=driver.findElement(By.id("button-cart"));

		Qty.clear();
		Qty.sendKeys("0");
		AddCart.click();

		Thread.sleep(3000);
		
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}

		//Validation
		String ExpectedMessage="Success: You have added ";
		String ActualMessage=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();


		if(ActualMessage.contains(ExpectedMessage))
		{
			System.out.println("TC_Invalid_002 Test Failed");

			//Highlight Element with red border 3px width
			WebElement Message=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible"));
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'",Message);

			windowSizeScreenshot();
		}

		else
		{
			System.out.println("TC_Invalid_002 Test Passed.");
		}

	}

	
	public static void TC_Invalid_003() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		WebElement Qty=driver.findElement(By.id("input-quantity"));
		WebElement AddCart=driver.findElement(By.id("button-cart"));

		Qty.clear();
		Qty.sendKeys("");
		AddCart.click();

		Thread.sleep(3000);

		//Validation
		String ExpectedMessage="Success: You have added ";
		String ActualMessage=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();

		if(ActualMessage.contains(ExpectedMessage))
		{
			System.out.println("TC_Invalid_003 Test Failed");
		}

		else
		{
			System.out.println("TC_Invalid_003 Test Passed.");
		}
	}

	
	public static void TC_Invalid_004() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		WebElement Qty=driver.findElement(By.id("input-quantity"));
		WebElement AddCart=driver.findElement(By.id("button-cart"));

		Qty.clear();
		Qty.sendKeys("dsdsa");
		AddCart.click();

		Thread.sleep(3000);

		//Validation
		String ExpectedMessage="Success: You have added ";
		String ActualMessage=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();

		if(ActualMessage.contains(ExpectedMessage))
		{
			System.out.println("TC_Invalid_004 Test Failed");
		}

		else
		{
			System.out.println("TC_Invalid_004 Test Passed.");
		}
	}

	
	public static void TC_Invalid_005() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		WebElement Qty=driver.findElement(By.id("input-quantity"));
		WebElement AddCart=driver.findElement(By.id("button-cart"));

		Qty.clear();
		Qty.sendKeys("-1");
		AddCart.click();	

		Thread.sleep(3000);

		//Validation
		String ExpectedMessage="Success: You have added ";
		String ActualMessage=driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")).getText();

		if(ActualMessage.contains(ExpectedMessage))
		{
			System.out.println("TC_Invalid_005 Test Failed");
		}

		else
		{
			System.out.println("TC_Invalid_005 Test Passed.");
		}
	}
	

}
