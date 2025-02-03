package javaSeleniumUIAutomation.Tests;
import org.testng.annotations.Test;

import JavaSeleniumUIAutomation.pageobjects.LandingPage;
import javaSeleniumUIAutomation.TestComponents.BaseTest;

import java.io.IOException;
public class SuccessfulLogIn extends BaseTest{

	
	
	@Test
	public void successfulLogIn() throws IOException
	{

		LandingPage landingpage = launchApplication();
		landingpage.loginApplication("sumitkoley727@gmail.com", "Sumit@123");
		
	}

}
