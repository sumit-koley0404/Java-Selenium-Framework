package javaSeleniumUIAutomation.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import JavaSeleniumUIAutomation.pageobjects.LandingPage;
import javaSeleniumUIAutomation.TestComponents.BaseTest;


import java.io.IOException;
public class LogIn extends BaseTest{

	
	
	@Test
	public void successfulLogIn() throws IOException
	{

		LandingPage landingPage = launchApplication();
		landingPage.loginApplication("sumitkoley727@gmail.com", "Sumit@123");
		Assert.assertEquals(landingPage.automationText(), "AUTOMATION");	
		
	}
	@Test
	public void unsuccessfulLogIn() throws IOException {
		LandingPage landingPage = launchApplication();
		landingPage.loginApplication("sumtkoley@gmail.com", "12345");
		Assert.assertEquals(landingPage.invalidMessage(), "Incorrect email or password.");
	}

}
