package com.tatasky.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsernameTexbox() {
		WebElement un = driver.findElement(By.id("username"));
		return un;
	}
	
	public WebElement getPasswordTextbox() {
		return driver.findElement(By.name("pwd"));		
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.id("loginButton"));
	}
	
	public WebElement getLoginErrorMsg() {
		return driver.findElement(By.xpath("//span[contains(text(), 'Username or Password is invalid.')]"));
	}
	public void waitForLoginPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginFormContainer"))));
	}

}
