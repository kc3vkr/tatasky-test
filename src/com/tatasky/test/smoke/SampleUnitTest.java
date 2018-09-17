package com.tatasky.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tatasky.object.ui.LoginPage;
import com.tatasky.utils.CreateDriver;

public class SampleUnitTest {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondtion() {
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@Test
	public void testApp()
	{
		login.waitForLoginPageToLoad();
		String actualResult = driver.getTitle();
		String expectedResult = "actiTIME - Login";
		Assert.assertEquals(actualResult, expectedResult);
	}
}
