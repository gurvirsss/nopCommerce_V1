package com.nopCommerce_V1.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce_V1.pageobjects.LoginPage;

public class LoginTest001 extends BaseClass{
	
	
	
	@Test
	public void LoginTest() throws IOException, InterruptedException
	
	{
		driver.get(baseURL);
				
		LoginPage lp=new LoginPage(driver);
		
		logger.info("providing user name");
		lp.setUserName(username);
		
		lp.setPassword(password);
		logger.info("providing password");

		
		lp.clickLogin();
		logger.info("Click on Login");

		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			
				{
			Thread.sleep(5000);
					lp.clickLogout();
				
				Assert.assertTrue(true);
				logger.info("login is successful");
				
	             }
	
	else
	{
		captureScreen(driver,"LoginTest001");
		Assert.assertTrue(false);
		logger.info("login is not successful");
        
	}
				
	}
	
	}
	


