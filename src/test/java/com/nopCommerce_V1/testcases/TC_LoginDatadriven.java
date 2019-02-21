package com.nopCommerce_V1.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce_V1.Utilities.XLUtils;
import com.nopCommerce_V1.pageobjects.LoginPage;

public class TC_LoginDatadriven extends BaseClass {
	
	@Test(dataProvider="logindata")
	public void logintest(String user, String pwd)
	
	{
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("providing user name");
		lp.setUserName(user);
		
		lp.setPassword(pwd);
		logger.info("providing password");

		
		lp.clickLogin();
		logger.info("Click on Login");

		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			
				{
					lp.clickLogout();
				
				
				logger.info("login is successful");
				
				Assert.assertTrue(true);
				
	             }
	
	else
	{
		
		Assert.assertTrue(false);
		logger.error("login is not successful");
        
	}
				
	
	}

	
	@DataProvider(name="logindata")
			
			public String[][] GetData() throws IOException
			{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopCommerce_V1/testdata/LoginData.xlsx";
			
		int	rownum=XLUtils.getRowCount(path, "Sheet1");
		int col=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String Logindata[][]=new String[rownum][col];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<col;j++)
			{
				Logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return Logindata;
			}

	
	
}
