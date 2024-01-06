package com.inetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username entered");
		
		lp.setPassword(password);
		logger.info("Password entered");
		
		lp.clickSubmit();
		logger.info("Button clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager Homepage"))
		{
			Assert.assertTrue(true);
			logger.info("Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");		//loginTest is the test case name
			Assert.assertTrue(false);
			logger.info("Failed");
		}
	}
}
