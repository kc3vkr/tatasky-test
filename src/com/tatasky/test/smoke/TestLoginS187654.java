package com.tatasky.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tatasky.object.ui.LoginPage;
import com.tatasky.utils.CreateDriver;

public class TestLoginS187654 {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	public void postCondtion() {
		driver.close();
	}
	
	@Test
	public void testLoginInvalidTC197543() {
		//Wait for login page to load
		login.waitForLoginPageToLoad();
		//Get title and verify title of Web page
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//Enter valid UserName
		login.getUsernameTexbox().sendKeys("admain");
		//Enter invalid Password
		login.getPasswordTextbox().sendKeys("Invalid");
		//Click on Login
		login.getLoginButton().click();
		//Get error message and verify
		String actualErrorMsg = login.getLoginErrorMsg().getText();
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		
	}

}
