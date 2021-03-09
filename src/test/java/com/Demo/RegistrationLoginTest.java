package com.Demo;

import java.io.IOException;

import com.Base.BaseClass;
import com.Registration.Registration;
import com.login.LoginTest;



public class RegistrationLoginTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		launchChrome();
		HomePage.openHomepage();
		Registration.openRegistrationURL();
		Registration.RegisterInsertData();
		HomePage.openHomepage();
		LoginTest.openLoginURL(); 
		LoginTest.emailPassValid();
		tearDownChrome();
	}

}
