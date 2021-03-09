package com.Demo;

import com.Base.BaseClass;

public class HomePage extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		launchChrome();
		openHomepage();
		tearDownChrome();

	}
	
	public static void openHomepage() throws InterruptedException
	{
		driver.get("https://demo.opencart.com/");
		Thread.sleep(3000);
	}

}
