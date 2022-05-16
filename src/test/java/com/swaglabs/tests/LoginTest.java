package com.swaglabs.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.LoginPage;

public class LoginTest extends BaseTest {
		
	@Test
	public void TC03_validateBlankInput() {
		Reporter.log("RUN: TC03_validateBlankInput<br>");
		driver.navigate().to("https://www.saucedemo.com/");
		
		 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		 loginPage.clickLogin();
		 
		 String actualErrorMsg = loginPage.getErrorMsg();
		 String expectedErrorMsg = "Epic sadface: Username is required";
		 
		 Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
		 Reporter.log("PASSED: TC03_validateBlankInput<br>");
	}
	
	@Test
	public void TC01_validateSuccessfulLogin() {
		driver.navigate().to("https://www.saucedemo.com/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.login("standard_user", "secret_sauce");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		Assert.assertTrue(homePage.getPageTitle().isDisplayed());
		
	}

}
