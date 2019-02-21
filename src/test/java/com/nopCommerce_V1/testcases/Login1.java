package com.nopCommerce_V1.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce_V1.pageobjects.LoginPage;

public class Login1 extends base1{
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
